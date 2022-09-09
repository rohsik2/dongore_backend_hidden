package com.sns.dongore.photo;

import com.sns.dongore.photo.model.Photo;
import com.sns.dongore.user.model.GetUserRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository @Slf4j
public class PhotoRepo {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Long createPhoto(String url, Long feed){
        String query = "INSERT INTO Photo(url, feed)"
                + "VALUES(?, ?)";

        Object[] params = new Object[]{url, feed};
        jdbcTemplate.update(query, params);
        String lastInsertIdQuery = "SELECT MAX(id) FROM Photo";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, Long.class);
    }

    public Photo findPhotoById(Long photoId){
        String getQuery = "SELECT * FROM Photo WHERE id = ?";
        Object[] params = new Object[]{ photoId };

        return jdbcTemplate.queryForObject(getQuery,
                (rs, rowNum) -> new Photo(
                        rs.getLong("id"),
                        rs.getString("url"),
                        rs.getLong("feed"),
                        rs.getDate("created_at")), params);
    }

    public Boolean isPhotoIdExist(Long photoId){
        String getQuery = "SELECT COUNT(*) FROM Photo WHERE id = ?";
        Object[] params = new Object[]{ photoId };
        return (jdbcTemplate.queryForObject(getQuery, Integer.class, params) != 0);
    }

    public List<Photo> searchByFeedId(Long feedId) {
        String getQuery = "SELECT * FROM Photo WHERE feed = ?";
        Object[] params = new Object[]{ feedId };

        return jdbcTemplate.query(getQuery,
                (rs, rowNum) -> new Photo(
                        rs.getLong("id"),
                        rs.getString("url"),
                        rs.getLong("feed"),
                        rs.getDate("created_at")), params);
    }
}

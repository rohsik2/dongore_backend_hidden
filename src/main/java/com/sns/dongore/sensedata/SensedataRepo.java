package com.sns.dongore.sensedata;

import com.sns.dongore.feed.model.PostFeedReq;
import com.sns.dongore.sensedata.model.Sensedata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository @Slf4j
public class SensedataRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Sensedata findById(Long sensedata) {
        String getQuery = "SELECT * FROM SenseData WHERE id = ?";
        Object[] params = new Object[]{sensedata};

        return jdbcTemplate.queryForObject(getQuery,
                (rs, rowNum) -> new Sensedata(
                        rs.getLong("id"),
                        rs.getShort("auditory"),
                        rs.getShort("visual"),
                        rs.getShort("vestibular"),
                        rs.getShort("tactile"),
                        rs.getShort("proprioceptive"),
                        rs.getShort("oral")), params);
    }


    public Long createSensedata(PostFeedReq req) {
        String getQuery = "INSERT INTO SenseData(auditory, visual, vestibular, tactile, proprioceptive, oral)"
                + " VALUES(?, ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{req.getAuditory(), req.getVisual(), req.getVestibular(), req.getTactile(), req.getProprioceptive(), req.getOral()};

        jdbcTemplate.update(getQuery, params);
        String lastInsertIdQuery = "SELECT MAX(id) from SenseData";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, Long.class);
    }

}


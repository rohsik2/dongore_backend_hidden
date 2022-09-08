package com.sns.dongore.user;

import com.sns.dongore.user.model.AppUser;
import com.sns.dongore.user.model.PostUserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository @Slf4j
public class AppUserRepo {

    // write Query using JDBC Template
    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public AppUser getUserBy;
    public Long createUser(PostUserReq req) {
        String query = "INSERT INTO AppUser(username, email, password, nickname, role, county, city)"
                + "VALUES(?, ?, ?, ?, 1, ?, ?)";

        Object[] params = new Object[]{req.getUsername(), req.getEmail(), req.getPassword(), req.getNickname(), req.getCounty(), req.getCity()};
        jdbcTemplate.update(query, params);
        String lastInsertIdQuery = "SELECT MAX(id) from AppUser"; // 가장 마지막에 삽입된(생성된) id 값은 가져온다.
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, Long.class); // 해당 쿼리문의 결과 마지막으로 삽인된 유저의 customerId 번호를 반환한다.
    }


    public Boolean isNicknameExist(String nickname) {
        String getQuery = "SELECT COUNT(*) FROM AppUser WHERE nickname like ?";
        Object[] params = new Object[]{ nickname };

        return (jdbcTemplate.queryForObject(getQuery, Integer.class, params)) != 0;
    }

    public Boolean isEmailExist(String email) {
        String getQuery = "SELECT COUNT(*) FROM AppUser WHERE email like ?";
        Object[] params = new Object[]{ email };
        return (jdbcTemplate.queryForObject(getQuery, Integer.class, params)) != 0;
    }

    public AppUser getUserByEmail(String email) {
        String getQuery = "SELECT * FROM AppUser WHERE email like ?";
        Object[] params = new Object[]{ email };

        return jdbcTemplate.queryForObject(getQuery,
                (rs, rowNum) -> new AppUser(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getDate("birth"),
                    rs.getString("nickname"),
                    rs.getLong("role"),
                    rs.getDate("created_at"),
                    rs.getDate("updated_at"),
                    rs.getInt("status"),
                    rs.getString("type"),
                    rs.getString("county"),
                    rs.getString("city")), params);
    }

    public boolean isIdExist(Long appUserId) {
        String getQuery = "SELECT COUNT(*) FROM appuser WHERE id = ?";
        Object[] params = new Object[]{ appUserId };
        return (jdbcTemplate.queryForObject(getQuery, Integer.class, params)) != 0;
    }

    public AppUser findUserById(Long appUserId) {
        String getQuery = "SELECT * FROM appuser WHERE id = ?";
        Object[] params = new Object[]{ appUserId };

        return jdbcTemplate.queryForObject(getQuery,
                (rs, rowNum) -> new AppUser(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getDate("birth"),
                        rs.getString("nickname"),
                        rs.getLong("role"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at"),
                        rs.getInt("status"),
                        rs.getString("type"),
                        rs.getString("county"),
                        rs.getString("city")), params);
    }
}

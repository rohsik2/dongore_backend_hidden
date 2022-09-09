package com.sns.dongore.sensedata;

import com.sns.dongore.feed.model.PostFeedReq;
import com.sns.dongore.sensedata.model.LocationAvgSenseData;
import com.sns.dongore.sensedata.model.Sensedata;
import com.sns.dongore.user.model.PostUserReq;
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

        Object[] params = new Object[]{req.getSense_auditory(), req.getSense_visual(), req.getSense_vestibular(), req.getSense_tactile(), req.getSense_proprioceptive(), req.getSense_oral()};

        jdbcTemplate.update(getQuery, params);
        String lastInsertIdQuery = "SELECT MAX(id) from SenseData";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, Long.class);
    }
    public Long createSensedata(PostUserReq req) {
        String getQuery = "INSERT INTO SenseData(auditory, visual, vestibular, tactile, proprioceptive, oral)"
                + " VALUES(?, ?, ?, ?, ?, ?)";

        Object[] params = new Object[]{req.getSense_auditory(), req.getSense_visual(), req.getSense_vestibular(), req.getSense_tactile(), req.getSense_proprioceptive(), req.getSense_oral()};

        jdbcTemplate.update(getQuery, params);
        String lastInsertIdQuery = "SELECT MAX(id) from SenseData";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery, Long.class);
    }


    public LocationAvgSenseData getAvgFromLocation(Long locationId) {
        String getQuery = "Select avg(s.auditory) as auditory "+
                ",avg(s.visual) as visual " +
                ",avg(s.vestibular) as vestibular " +
                ",avg(s.tactile) as tactile " +
                ",avg(s.proprioceptive) as proprioceptive " +
                ",avg(s.oral) as oral " +
                "from Sensedata s, Feed f " +
                "where f.location = ? and f.sensedata = s.id ";
        Object[] params = new Object[]{locationId};

        return jdbcTemplate.queryForObject(getQuery, (rs,rowNum) -> (
                new LocationAvgSenseData(
                        locationId,
                        rs.getShort("auditory"),
                        rs.getShort("visual"),
                        rs.getShort("vestibular"),
                        rs.getShort("tactile"),
                        rs.getShort("proprioceptive"),
                        rs.getShort("oral")
                )),params);
    }
}


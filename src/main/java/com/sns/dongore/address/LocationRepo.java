package com.sns.dongore.address;

import com.sns.dongore.address.model.Location;
import com.sns.dongore.address.model.PostLocationReq;
import com.sns.dongore.feed.model.PostFeedReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class LocationRepo {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Boolean isLocationIdExist(Long id){
        String query = "select count(*) from location where id = ?";
        Object[] params = {id};
        return jdbcTemplate.queryForObject(query, Integer.class, params) == 1;
    }

    public Location findById(Long id){
        String findQuery = "select * from location where id = ?";
        Object[] params = {id};
        return jdbcTemplate.queryForObject(findQuery, ((rs, rowNum) ->
                new Location(
                        rs.getLong("id"),
                        rs.getDouble("lat"),
                        rs.getDouble("long"),
                        rs.getString("placename"),
                        rs.getString("city"),
                        rs.getString("county"),
                        rs.getString("category"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                )), params);
    }

    public Long createLocation(PostLocationReq req){
        String insertQuery = "insert into Location(lat, long, placename, city, county, category) " +
                "values(?, ?, ?, ?, ?, ?)";
        Object[] params = {req.getLatitude(), req.getLongitude(), req.getPlaceName(), req.getCity(), req.getCounty(), req.getCategory()};
        jdbcTemplate.update(insertQuery, params);
        return jdbcTemplate.queryForObject("select max(id) from location", Long.class);
    }

    public Long findByLatLongPlaceName(Double latitude, Double longitude, String placeName) {
        String findQuery = "select id from location where lat = ? and long = ? and placeName like ?";
        Object[] params = {latitude, longitude, placeName};
        return jdbcTemplate.queryForObject(findQuery, Long.class, params);
    }

    public Boolean isPlaceExist(Double latitude, Double longitude, String placeName){
        String findQuery = "select count(*) from location where lat = ? and long = ? and placeName like ?";
        Object[] params = {latitude, longitude, placeName};
        return jdbcTemplate.queryForObject(findQuery, Integer.class, params) == 1;
    }
}

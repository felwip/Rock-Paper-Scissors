package com.rps.restservicecors.dao;

import com.rps.restservicecors.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, User user) {
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (resultSet, i)-> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String rank = resultSet.getString("rank");
            String avatarUrl = resultSet.getString("avatarUrl");
            return new User(id, name, rank, avatarUrl);});
    }

    @Override
    public User getUserById(UUID id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i)-> {
            UUID userId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String rank = resultSet.getString("rank");
            String avatarUrl = resultSet.getString("avatarUrl");
            return new User(userId, name, rank, avatarUrl);}, id);
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return 0;
    }
}

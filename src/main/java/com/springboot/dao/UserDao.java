package com.springboot.dao;

import com.springboot.domain.User;
import com.springboot.domain.dto.UserRequestDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(final UserRequestDto userRequestDto){
        this.jdbcTemplate.update("insert into users(id, name, password) values (?, ?, ?)",
                userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
    }
    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }
    public void deleteById(String id){
        this.jdbcTemplate.update("delete from users where id=?", id);
    }
    public User findById(String id){
        RowMapper<User> rowMapper=new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };
        return this.jdbcTemplate.queryForObject("select * from users where id=?", rowMapper, id);
    }
}

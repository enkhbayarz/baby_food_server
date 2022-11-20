package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<User> get(){
        log.info("START /GET getUset REPOSITORY");
        return jdbcTemplate.query("SELECT * FROM TB_USER",
                new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getByUsername(String username){
        log.info("START /GET getUserByUsername Repository");
        log.debug("REQ username: {}", username);
        return jdbcTemplate.query("SELECT * FROM TB_USER where username = ? or email = ?",
                new BeanPropertyRowMapper<>(User.class), username, username);
    }
    public List<User> getById(Integer id){
        log.info("START /GET getUserById Repository");
        log.debug("REQ id: {}", id);
        return jdbcTemplate.query("SELECT * FROM TB_USER where id = ?",
                new BeanPropertyRowMapper<>(User.class), id);
    }

    public Integer post(User user){
        log.info("START /POST insertUser Repository");
        log.debug("REQ user: {}", user);
        return jdbcTemplate.update("INSERT INTO TB_USER (username, password, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, current_timestamp, current_timestamp)",
                user.getUsername(), user.getPassword(), user.getType(), user.getStatus());
    }
    public Integer update(User user){
        log.info("START /PUT updateUser Repository");
        log.debug("REQ user: {}", user);
        return jdbcTemplate.update("update TB_USER SET email = ?, phone = ?, name = ?, updated_on = current_timestamp WHERE id = ?",
                user.getEmail(), user.getPhone(), user.getName(), user.getId());
    }
}

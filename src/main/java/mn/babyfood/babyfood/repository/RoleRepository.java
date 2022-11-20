package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RoleRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Role> get(){

        return jdbcTemplate.query("SELECT * FROM TB_ROLE", new BeanPropertyRowMapper<>(Role.class));
    }
    public Integer post(Role r){

        return jdbcTemplate.update("INSERT INTO TB_ROLE (name, description, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, current_timestamp, current_timestamp)",
                r.getName(), r.getDescription(), r.getType(), r.getStatus());
    }
}

package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.UserRole;
import mn.babyfood.babyfood.model.UserRoleById;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRoleRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<UserRole> get(){

        return jdbcTemplate.query("SELECT * FROM TB_USER_ROLE", new BeanPropertyRowMapper<>(UserRole.class));
    }
    public List<UserRoleById> getByUserId(Integer userid){
        String sql = "select r.name from tb_user_role ur, tb_role r where ur.user_id = ? and ur.role_id = r.id";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserRoleById.class), userid);
    }
    public Integer post(UserRole u){

        return jdbcTemplate.update("INSERT INTO TB_USER_ROLE (user_id, role_id, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, current_timestamp, current_timestamp)",
                u.getUser_id(), u.getRole_id(), u.getType(), u.getStatus());
    }
}

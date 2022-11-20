package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Child;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class ChildRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Child> get(){
        log.info("START /GET getChild Repository");
        return jdbcTemplate.query("SELECT id, name, gender, weight, height, index, type, status, user_id, index_id,to_char(born_date, 'yyyy-mm-dd') born_date,to_char(created_on, 'yyyy-mm-dd HH24:MI:SS') created_on FROM TB_CHILD",
                new BeanPropertyRowMapper<>(Child.class));
    }
    public List<Child> getByUserId(Integer userid){
        log.info("START /GET getChildByUserId Repository");
        log.debug("REQ userId: {}", userid);
        return jdbcTemplate.query("SELECT id, name, gender, weight, height, index, type, status, user_id, index_id,to_char(born_date, 'yyyy-mm-dd') born_date,to_char(created_on, 'yyyy-mm-dd HH24:MI:SS') created_on FROM TB_CHILD where user_id = ?",
                new BeanPropertyRowMapper<>(Child.class), userid);
    }
    public Integer post(Child c){
        log.info("START /POST insertChild Repository");
        log.debug("REQ child: {}", c);
        return jdbcTemplate.update("INSERT INTO TB_CHILD (name, born_date, gender, weight, height, index, type, status, user_id, index_id, birth, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                c.getName(), c.getBorn_date(), c.getGender(), c.getWeight(), c.getHeight(), c.getIndex(), c.getType(), c.getStatus(), c.getUser_id(), c.getIndex_id(), c.getBirth());
    }
}

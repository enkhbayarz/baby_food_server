package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Advice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AdviceRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Advice> get(){

        return jdbcTemplate.query("SELECT * FROM TB_ADVICE", new BeanPropertyRowMapper<>(Advice.class));
    }
    public List<Advice> getByType(String type){

        return jdbcTemplate.query("SELECT * FROM TB_ADVICE where type = ?", new BeanPropertyRowMapper<>(Advice.class), type);
    }
    public Integer post(Advice advice){

        return jdbcTemplate.update("INSERT INTO TB_ADVICE (name, description, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, current_timestamp, current_timestamp)",
                advice.getName(), advice.getDescription(), advice.getType(), advice.getStatus());
    }
}

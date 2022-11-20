package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Food;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class FoodRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Food> get(){
        log.info("START /GET FOOD Repository");

        return jdbcTemplate.query("SELECT * FROM TB_FOOD", new BeanPropertyRowMapper<>(Food.class));
    }
    public Integer post(Food f){

        return jdbcTemplate.update("INSERT INTO TB_FOOD (name, description, calorie, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                f.getName(), f.getDescription(), f.getCalorie(), f.getType(), f.getStatus());
    }
}

package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Meal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MealRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Meal> get(){

        return jdbcTemplate.query("SELECT * FROM TB_MEAL", new BeanPropertyRowMapper<>(Meal.class));
    }
    public List<Meal> getById(Integer id){

        return jdbcTemplate.query("SELECT * FROM TB_MEAL where id = ?", new BeanPropertyRowMapper<>(Meal.class), id);
    }
    public List<Meal> getByType(String type){

        return jdbcTemplate.query("SELECT * FROM TB_MEAL where type = ?", new BeanPropertyRowMapper<>(Meal.class), type);
    }
    public Integer post(Meal m){

        return jdbcTemplate.update("INSERT INTO TB_MEAL (name, description, calorie, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                m.getName(), m.getDescription(), m.getCalorie(), m.getType(), m.getStatus());
    }
}

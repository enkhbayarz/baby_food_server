package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.IndexMeal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class IndexMealRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<IndexMeal> get(){

        return jdbcTemplate.query("SELECT * FROM TB_INDEX_MEAL", new BeanPropertyRowMapper<>(IndexMeal.class));
    }
    public Integer post(IndexMeal i){

        return jdbcTemplate.update("INSERT INTO TB_INDEX_MEAL (name, description, index_id, meal_id, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                i.getName(), i.getDescription(), i.getIndex_id(), i.getMeal_id(), i.getType(), i.getStatus());
    }
}

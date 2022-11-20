package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.IngredientFood;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class IngredientFoodRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<IngredientFood> get(){

        return jdbcTemplate.query("SELECT * FROM TB_INGREDIENT_FOOD", new BeanPropertyRowMapper<>(IngredientFood.class));
    }
    public Integer post(IngredientFood i){

        return jdbcTemplate.update("INSERT INTO TB_INGREDIENT_FOOD (name, description, food_id, ingredient_id, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                i.getName(), i.getDescription(), i.getFood_id(), i.getIngredient_id(), i.getType(), i.getStatus());
    }
}

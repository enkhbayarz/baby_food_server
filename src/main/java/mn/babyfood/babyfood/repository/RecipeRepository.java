package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Recipe;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RecipeRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Recipe> get(){

        return jdbcTemplate.query("SELECT * FROM TB_RECIPE", new BeanPropertyRowMapper<>(Recipe.class));
    }
    public List<Recipe> getByMealId(Integer mealId){

        return jdbcTemplate.query("SELECT * FROM TB_RECIPE where meal_id = ?",
                new BeanPropertyRowMapper<>(Recipe.class), mealId);
    }
    public Integer post(Recipe r){

        return jdbcTemplate.update("INSERT INTO TB_RECIPE (name, ingredient_id, instruction_id, meal_id, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                r.getName(), r.getIngredient_id(), r.getInstruction_id(), r.getMeal_id(), r.getType(), r.getStatus());
    }
}

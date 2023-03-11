package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Ingredient;
import mn.babyfood.babyfood.payload.ingredient.IngredientRes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class IngredientRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Ingredient> get(){

        return jdbcTemplate.query("SELECT * FROM TB_INGREDIENT", new BeanPropertyRowMapper<>(Ingredient.class));
    }
    public List<IngredientRes> getById(Integer id, Integer childId ){

        return jdbcTemplate.query("select if.id, f.name, if.amount, if.amount_type\n" +
                "from tb_ingredient_food if,\n" +
                "     tb_food f\n" +
                "where if.food_id = f.id\n" +
                "  and if.ingredient_id = ? and f.id not in (select if.food_id from tb_child_food if where child_id = ?)\n" +
                "group by if.id, f.name, if.amount, if.amount_type", new BeanPropertyRowMapper<>(IngredientRes.class), id, childId);
    }
    public Integer post(Ingredient i){

        return jdbcTemplate.update("INSERT INTO TB_INGREDIENT (name, description, calorie, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                i.getName(), i.getDescription(), i.getCalorie(), i.getType(), i.getStatus());
    }
}

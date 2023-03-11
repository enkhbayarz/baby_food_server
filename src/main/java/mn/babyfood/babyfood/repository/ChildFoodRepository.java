package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.ChildFood;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ChildFoodRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<ChildFood> get(){

        return jdbcTemplate.query("SELECT * FROM TB_CHILD_FOOD", new BeanPropertyRowMapper<>(ChildFood.class));
    }
    public List<ChildFood> getByChild(Integer id){
        return jdbcTemplate.query("SELECT * FROM TB_CHILD_FOOD where child_id = ?",
                new BeanPropertyRowMapper<>(ChildFood.class), id);
    }
    public Integer post(ChildFood childFood){

        return jdbcTemplate.update("INSERT INTO TB_CHILD_FOOD (name, description, child_id, food_id, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                childFood.getName(), childFood.getDescription(), childFood.getChild_id(), childFood.getFood_id(), childFood.getType(), childFood.getStatus());
    }
    public Integer delete(ChildFood childFood){

        return jdbcTemplate.update("DELETE FROM TB_CHILD_FOOD WHERE id = ?",
                childFood.getId());
    }
}

package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.ChildIndexHistory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ChildIndexHistoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<ChildIndexHistory> get(){

        return jdbcTemplate.query("SELECT * FROM TB_CHILD_FOOD_INDEX_HISTORY", new BeanPropertyRowMapper<>(ChildIndexHistory.class));
    }
    public Integer post(ChildIndexHistory c){

        return jdbcTemplate.update("INSERT INTO TB_CHILD_FOOD_INDEX_HISTORY (weight, height, index, type, status, child_id, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                c.getWeight(), c.getHeight(), c.getIndex(), c.getType(), c.getStatus(), c.getChild_id());
    }
}

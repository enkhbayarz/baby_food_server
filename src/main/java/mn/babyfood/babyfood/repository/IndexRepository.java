package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Index;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class IndexRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Index> get(){

        return jdbcTemplate.query("SELECT * FROM TB_INDEX", new BeanPropertyRowMapper<>(Index.class));
    }
    public Integer post(Index i){

        return jdbcTemplate.update("INSERT INTO TB_INDEX (index_number, type, status, created_on, updated_on) VALUES(?, ?, ?, current_timestamp, current_timestamp)",
                i.getIndex_number(), i.getType(), i.getStatus());
    }
}

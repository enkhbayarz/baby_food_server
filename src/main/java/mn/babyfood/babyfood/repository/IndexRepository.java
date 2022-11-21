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
        return jdbcTemplate.update("INSERT INTO TB_INDEX (month, i_num_m_3, i_num_m_2, i_num_m_1, i_num_med, i_num_p_1, i_num_p_2, i_num_p_3, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                i.getMonth(), i.getI_num_m_3(), i.getI_num_m_2(), i.getI_num_m_1(), i.getI_num_med(), i.getI_num_p_1(), i.getI_num_p_2(), i.getI_num_p_3(), i.getType(), i.getStatus());
    }
}

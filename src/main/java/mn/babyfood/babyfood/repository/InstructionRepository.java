package mn.babyfood.babyfood.repository;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Instruction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class InstructionRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Instruction> get(){

        return jdbcTemplate.query("SELECT * FROM TB_INSTRUCTION", new BeanPropertyRowMapper<>(Instruction.class));
    }
    public List<Instruction> getById(Integer id){

        return jdbcTemplate.query("SELECT * FROM TB_INSTRUCTION where id = ?",
                new BeanPropertyRowMapper<>(Instruction.class), id);
    }
    public Integer post(Instruction i){

        return jdbcTemplate.update("INSERT INTO TB_INSTRUCTION (name, description, instruction, type, status, created_on, updated_on) VALUES(?, ?, ?, ?, ?, current_timestamp, current_timestamp)",
                i.getName(), i.getDescription(), i.getInstruction(), i.getType(), i.getStatus());
    }
}

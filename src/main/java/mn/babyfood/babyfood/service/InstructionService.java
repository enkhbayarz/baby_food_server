package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Instruction;
import mn.babyfood.babyfood.repository.InstructionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InstructionService {
    private final InstructionRepository instructionRepository;

    public List<Instruction> get() {
        return instructionRepository.get();
    }

    public List<Instruction> getById(Integer id) {
        return instructionRepository.getById(id);
    }

    public Integer post(Instruction instruction) {
        return instructionRepository.post(instruction);
    }
}

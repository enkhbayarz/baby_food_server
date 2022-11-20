package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Advice;
import mn.babyfood.babyfood.repository.AdviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AdviceService {

    private final AdviceRepository adviceRepository;

    public List<Advice> get() {
        return adviceRepository.get();
    }
    public List<Advice> getByType(String type) {
        return adviceRepository.getByType(type);
    }
    public Integer post(Advice advice){
        return adviceRepository.post(advice);
    }

}

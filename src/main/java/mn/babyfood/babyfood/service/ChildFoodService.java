package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.ChildFood;
import mn.babyfood.babyfood.repository.ChildFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ChildFoodService {
    private final ChildFoodRepository childFoodRepository;

    public List<ChildFood> get() {
        return childFoodRepository.get();
    }
    public List<ChildFood> getByChild(Integer id) {
        return childFoodRepository.getByChild(id);
    }
    public Integer post(ChildFood childFood){
        return childFoodRepository.post(childFood);
    }
}

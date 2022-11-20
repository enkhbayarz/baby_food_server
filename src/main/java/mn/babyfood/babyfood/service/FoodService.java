package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Food;
import mn.babyfood.babyfood.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class FoodService {
    private final FoodRepository foodRepository;

    public List<Food> get() {
        log.info("START /GET FOOD SERVICE");

        return foodRepository.get();
    }

    public Integer post(Food food) {
        return foodRepository.post(food);
    }
}

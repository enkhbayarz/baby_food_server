package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.IndexMeal;
import mn.babyfood.babyfood.repository.IndexMealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IndexMealService {
    private final IndexMealRepository indexMealRepository;

    public List<IndexMeal> get() {
        return indexMealRepository.get();
    }

    public Integer post(IndexMeal indexMeal) {
        return indexMealRepository.post(indexMeal);
    }
}

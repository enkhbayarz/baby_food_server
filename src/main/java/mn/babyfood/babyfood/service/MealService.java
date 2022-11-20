package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Meal;
import mn.babyfood.babyfood.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MealService {
    private final MealRepository mealRepository;

    public List<Meal> get() {
        return mealRepository.get();
    }
    public List<Meal> getByType(String type) {
        return mealRepository.getByType(type);
    }

    public List<Meal> getById(Integer id) {
        return mealRepository.getById(id);
    }

    public Integer post(Meal meal) {
        return mealRepository.post(meal);
    }
}


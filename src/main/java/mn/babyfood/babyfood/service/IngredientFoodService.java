package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.IngredientFood;
import mn.babyfood.babyfood.repository.IngredientFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IngredientFoodService {
    private final IngredientFoodRepository ingredientFoodRepository;

    public List<IngredientFood> get() {
        return ingredientFoodRepository.get();
    }

    public Integer post(IngredientFood ingredientFood) {
        return ingredientFoodRepository.post(ingredientFood);
    }
}

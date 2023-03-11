package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Ingredient;
import mn.babyfood.babyfood.payload.ingredient.IngredientRes;
import mn.babyfood.babyfood.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> get() {
        return ingredientRepository.get();
    }

    public List<IngredientRes> getById(Integer id, Integer childId) {
        return ingredientRepository.getById(id, childId);
    }

    public Integer post(Ingredient ingredient) {
        return ingredientRepository.post(ingredient);
    }
}

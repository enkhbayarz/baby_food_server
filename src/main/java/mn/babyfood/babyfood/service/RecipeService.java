package mn.babyfood.babyfood.service;

import lombok.AllArgsConstructor;
import mn.babyfood.babyfood.model.Recipe;
import mn.babyfood.babyfood.payload.recipe.RecipeRes;
import mn.babyfood.babyfood.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final InstructionService instructionService;
    private final IngredientService ingredientService;
    private final MealService mealService;

    public List<Recipe> get() {
        return recipeRepository.get();
    }
    public RecipeRes getByMealId(Integer mealId) {
        final var recipe=  recipeRepository.getByMealId(mealId).get(0);

        final var instruction  = instructionService.getById(recipe.getInstruction_id());

        final var meal = mealService.getById(mealId);

        final var ingredientRes = ingredientService.getById(recipe.getIngredient_id());
        System.out.println(ingredientRes);

        return RecipeRes.builder()
                .meal(meal)
                .instruction(instruction)
                .ingredient(ingredientRes)
                .build();
    }

    public Integer post(Recipe recipe) {
        return recipeRepository.post(recipe);
    }
}

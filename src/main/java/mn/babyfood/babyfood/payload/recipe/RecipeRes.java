package mn.babyfood.babyfood.payload.recipe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mn.babyfood.babyfood.model.Instruction;
import mn.babyfood.babyfood.model.Meal;
import mn.babyfood.babyfood.payload.ingredient.IngredientRes;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RecipeRes {
    private List<Meal> meal;
    private List<Instruction> instruction;
    private List<IngredientRes> ingredient;
}

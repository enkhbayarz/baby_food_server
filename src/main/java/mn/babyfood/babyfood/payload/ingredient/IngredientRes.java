package mn.babyfood.babyfood.payload.ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class IngredientRes {
    private Integer id;
    private String name;
    private String amount;
    private String amount_type;
}

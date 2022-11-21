package mn.babyfood.babyfood.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class IngredientFood {
    private Integer id;
    private String name;
    private String description;
    private Integer food_id;
    private Integer ingredient_id;
    private String type;
    private String status;
    private Integer amount;
    private String amount_type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_on;
}

package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.IngredientFood;
import mn.babyfood.babyfood.service.IngredientFoodService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingredient-food")
@AllArgsConstructor
@Slf4j
public class IngredientFoodController {
    private final IngredientFoodService ingredientFoodService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getIngredientFood CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(ingredientFoodService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getIngredientFood CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getIngredientFood CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody IngredientFood ingredientFood) {
        log.info("START /POST postIngredientFood CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(ingredientFoodService.post(ingredientFood));
        } catch (final Exception ex) {
            log.error("ERROR /POST postIngredientFood CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postIngredientFood CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

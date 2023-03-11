package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Recipe;
import mn.babyfood.babyfood.service.RecipeService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recipe")
@AllArgsConstructor
@Slf4j
public class RecipeController {
    private final RecipeService recipeService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?>  get() {
        log.info("START /GET getRecipe CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(recipeService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getRecipe CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getRecipe CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("mealid")
    public ResponseEntity<?>  getByMealId(@RequestParam Integer id, @RequestParam Integer childId) {
        log.info("START /GET getRecipeByMealId CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(recipeService.getByMealId(id, childId));
        } catch (final Exception ex) {
            log.error("ERROR /GET getRecipeByMealId CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getRecipeByMealId CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Recipe recipe) {
        log.info("START /POST postRecipe CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody( recipeService.post(recipe));
        } catch (final Exception ex) {
            log.error("ERROR /POST postRecipe CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postRecipe CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

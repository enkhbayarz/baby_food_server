package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Meal;
import mn.babyfood.babyfood.service.MealService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meal")
@AllArgsConstructor
@Slf4j
public class MealController {
    private final MealService mealService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getMeal CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(mealService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getMeal CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getMeal CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("type")
    public ResponseEntity<?> getByType(@RequestParam String value) {
        log.info("START /GET getMeal CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(mealService.getByType(value));
        } catch (final Exception ex) {
            log.error("ERROR /GET getMeal CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getMeal CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Meal meal) {
        log.info("START /POST postMeal CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(mealService.post(meal));
        } catch (final Exception ex) {
            log.error("ERROR /POST postMeal CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postMeal CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

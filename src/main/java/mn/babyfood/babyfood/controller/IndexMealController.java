package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.IndexMeal;
import mn.babyfood.babyfood.service.IndexMealService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/index-meal")
@AllArgsConstructor
@Slf4j
public class IndexMealController {
    private final IndexMealService indexMealService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getIndexMeal CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(indexMealService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getIndexMeal CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getIndexMeal CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody IndexMeal indexMeal) {
        log.info("START /POST postIndexMeal CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(indexMealService.post(indexMeal));
        } catch (final Exception ex) {
            log.error("ERROR /POST postIndexMeal CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postIndexMeal CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

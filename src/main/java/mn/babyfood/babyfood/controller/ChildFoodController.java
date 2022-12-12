package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.ChildFood;
import mn.babyfood.babyfood.service.ChildFoodService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/child-food")
@AllArgsConstructor
@Slf4j
public class ChildFoodController {
    private final ChildFoodService childFoodService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getChildFood CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childFoodService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getChildFood CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getChildFood CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("child")
    public ResponseEntity<?> getByChild(@RequestParam Integer value) {
        log.info("START /GET getChildFood CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childFoodService.getByChild(value));
        } catch (final Exception ex) {
            log.error("ERROR /GET getChildFood CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getChildFood CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody ChildFood childFood) {
        log.info("START /POST postChildFood CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childFoodService.post(childFood));
        } catch (final Exception ex) {
            log.error("ERROR /POST postChildFood CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postChildFood CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

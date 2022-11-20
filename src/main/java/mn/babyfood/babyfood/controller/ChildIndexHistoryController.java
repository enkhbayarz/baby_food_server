package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.ChildIndexHistory;
import mn.babyfood.babyfood.service.ChildIndexHistoryService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/child-index-history")
@AllArgsConstructor
@Slf4j
public class ChildIndexHistoryController {
    private final ChildIndexHistoryService childIndexHistoryService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getChildIndexHistory CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childIndexHistoryService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getChildIndexHistory CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getChildIndexHistory CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody ChildIndexHistory childIndexHistory) {
        log.info("START /POST postChildIndexHistory CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childIndexHistoryService.post(childIndexHistory));
        } catch (final Exception ex) {
            log.error("ERROR /POST postChildIndexHistory CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postChildIndexHistory CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

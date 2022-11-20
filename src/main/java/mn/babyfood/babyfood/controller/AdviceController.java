package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Advice;
import mn.babyfood.babyfood.service.AdviceService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/advice")
@AllArgsConstructor
@Slf4j
public class AdviceController {

    private final AdviceService adviceService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getAdvice CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(adviceService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getAdvice CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getAdvice CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("type")
    public ResponseEntity<?> getByType(@RequestParam String value) {
        log.info("START /GET getAdvice CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(adviceService.getByType(value));
        } catch (final Exception ex) {
            log.error("ERROR /GET getAdvice CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getAdvice CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Advice advice) {
        log.info("START /POST postAdvice CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(adviceService.post(advice));
        } catch (final Exception ex) {
            log.error("ERROR /GET postAdvice CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET postAdvice CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

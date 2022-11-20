package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Child;
import mn.babyfood.babyfood.payload.UserPrincipal;
import mn.babyfood.babyfood.security.CurrentUser;
import mn.babyfood.babyfood.service.ChildService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/child")
@AllArgsConstructor
@Slf4j
public class ChildController {
    private final ChildService childService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getChild CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getChild CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getChild CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
    @GetMapping("userId")
    public ResponseEntity<?> getByUserId(@CurrentUser final UserPrincipal currentUser) {
        log.info("START /GET getChild CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childService.getByUserId(currentUser));
        } catch (final Exception ex) {
            log.error("ERROR /GET getChild CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getChild CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Child child, @CurrentUser final UserPrincipal currentUser) {
        log.info("START /POST postChild CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(childService.post(child, currentUser));
        } catch (final Exception ex) {
            log.error("ERROR /POST postChild CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postChild CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

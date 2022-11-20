package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.UserRole;
import mn.babyfood.babyfood.service.UserRoleService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-role")
@AllArgsConstructor
@Slf4j
public class UserRoleController {
    private final UserRoleService userRoleService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getUserRole CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(userRoleService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getUserRole CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getUserRole CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody UserRole userRole) {
        log.info("START /POST postUserRole CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody( userRoleService.post(userRole));
        } catch (final Exception ex) {
            log.error("ERROR /POST postUserRole CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postUserRole CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

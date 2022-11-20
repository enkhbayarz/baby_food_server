package mn.babyfood.babyfood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.babyfood.babyfood.model.Instruction;
import mn.babyfood.babyfood.service.InstructionService;
import mn.babyfood.babyfood.util.ApiUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instruction")
@AllArgsConstructor
@Slf4j
public class InstructionController {
    private final InstructionService instructionService;
    private final ApiUtil apiUtil;

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("START /GET getInstruction CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(instructionService.get());
        } catch (final Exception ex) {
            log.error("ERROR /GET getInstruction CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /GET getInstruction CONTROLLER");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Instruction instruction) {
        log.info("START /POST postInstruction CONTROLLER");
        var response = this.apiUtil.buildLocalizedResponse(null);
        try {
            response.setBody(instructionService.post(instruction));
        } catch (final Exception ex) {
            log.error("ERROR /POST postInstruction CONTROLLER: {}", ex.getMessage());
            response = this.apiUtil.setLocalizedErrorResponse(new String[] {ex.getMessage()}, response);
        } finally {
            log.info("END /POST postInstruction CONTROLLER");
        }
        return ResponseEntity.ok(response);

    }
}

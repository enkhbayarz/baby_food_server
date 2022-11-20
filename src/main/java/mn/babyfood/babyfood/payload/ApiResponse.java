package mn.babyfood.babyfood.payload;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object body;

    public ApiResponse(final Boolean success, final String message,
                       final Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }

    public ApiResponse(final Boolean success, final String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse() {
    }
}

package mn.babyfood.babyfood.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ChildFood {
    private Integer id;
    private String name;
    private String description;
    private String type;
    private String status;
    private Integer child_id;
    private Integer food_id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_on;
}

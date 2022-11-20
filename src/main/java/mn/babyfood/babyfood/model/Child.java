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
public class Child {
    private Integer id;
    private String name;
    private String gender;
    private Double weight;
    private Double height;
    private Double index;
    private String type;
    private String status;
    private String birth;
    private Integer user_id;
    private Integer index_id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_on;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date born_date;
}

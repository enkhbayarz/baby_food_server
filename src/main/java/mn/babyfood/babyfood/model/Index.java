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
public class Index {
    private Integer id;
    private Integer month;
    private Double i_num_m_3;
    private Double i_num_m_2;
    private Double i_num_m_1;
    private Double i_num_med;
    private Double i_num_p_1;
    private Double i_num_p_2;
    private Double i_num_p_3;
    private String type;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_on;
}

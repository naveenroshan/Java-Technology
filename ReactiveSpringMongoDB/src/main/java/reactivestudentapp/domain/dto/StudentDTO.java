package reactivestudentapp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String name;
    private String email;
    private String departmentName;
}

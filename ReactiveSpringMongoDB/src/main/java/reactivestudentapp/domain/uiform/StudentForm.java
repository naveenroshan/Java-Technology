package reactivestudentapp.domain.uiform;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentForm {
    private String id;
    private String name;
    private String email;
    private String password;
    private String dob;
    private String departmentName;
}

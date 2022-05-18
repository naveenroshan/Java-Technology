package reactivestudentapp.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "students_table")
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate dob;
    private String departmentName;
}

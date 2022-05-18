package reactivestudentapp.service;

import reactivestudentapp.domain.dto.StudentDTO;
import reactivestudentapp.domain.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactivestudentapp.domain.uiform.StudentForm;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactivestudentapp.repo.StudentRepo;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class StudentService {
//    @Autowired
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    public Flux<StudentDTO> getAllStudents() {
        return studentRepo.findAll()
                          .map(student -> {
                              StudentDTO dto = new StudentDTO();
                                dto.setId(student.getId());
                                dto.setName(student.getName());
                                dto.setEmail(student.getEmail());
                                dto.setDepartmentName(student.getDepartmentName());
                              return dto;
                          });
    }

    public Mono<StudentDTO> createStudent(StudentForm studentFormData){
        log.info("In the createStudent Method");
        Student student = new Student();
                student.setName(studentFormData.getName());
                student.setEmail(studentFormData.getEmail());
                student.setPassword(studentFormData.getPassword());
                student.setDob(LocalDate.parse(studentFormData.getDob(),
                                               DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        return studentRepo.save(student)
                        .map(studentFromDB -> {
                            StudentDTO dto = new StudentDTO();
                                dto.setId(studentFromDB.getId());
                                dto.setName(studentFromDB.getName());
                                dto.setEmail(studentFromDB.getEmail());
                                dto.setDepartmentName(studentFromDB.getDepartmentName());
                            return dto;
                        });
    }
}

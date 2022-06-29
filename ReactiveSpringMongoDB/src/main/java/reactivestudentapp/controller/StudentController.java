package reactivestudentapp.controller;

import reactivestudentapp.domain.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactivestudentapp.domain.uiform.StudentForm;
import reactivestudentapp.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/student")
@Slf4j
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public Flux<StudentDTO> getAllStudents(){
        log.info("In the Get Method");
        return studentService.getAllStudents()
                .log();
    }

    @PostMapping("/create")
    public Mono<StudentDTO> createStudent(@RequestBody StudentForm studentFormData){
        log.info("In the createStudent Method");
        return studentService.createStudent(studentFormData)
                .log();
    }
}

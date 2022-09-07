package com.example.ReactiveSpringMongoDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactivestudentapp.controller.StudentController;
import reactivestudentapp.domain.entities.Student;
import reactivestudentapp.service.StudentService;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest(controllers = StudentController.class)
@AutoConfigureWebTestClient
public class StudentControllerUnitTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private StudentService studentServiceMock;

    static String Student_Get_All_Url = "/all";

    @Test
    void getAllStudentTest(){
        //var students= List.of(new Student ("ram","am@gmail.com","1234"));
        // when(studentServiceMock.getAllStudents()).thenReturn(Flux.fromIterable())

        webTestClient.get()
                     .uri(Student_Get_All_Url)
                     .exchange()
                     .expectStatus()
                     .is2xxSuccessful()
                     .expectBodyList(Student.class)
                     .hasSize(1);
    }
}

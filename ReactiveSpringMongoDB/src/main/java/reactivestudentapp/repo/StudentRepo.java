package reactivestudentapp.repo;

import reactivestudentapp.domain.entities.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepo extends ReactiveMongoRepository<Student,String> {
}

package DatabaseAPI.DatabaseAPI;

import org.springframework.data.repository.CrudRepository;
import DatabaseAPI.DatabaseAPI.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}

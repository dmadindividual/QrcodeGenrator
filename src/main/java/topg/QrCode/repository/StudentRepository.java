package topg.QrCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import topg.QrCode.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

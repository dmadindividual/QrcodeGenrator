package topg.QrCode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import topg.QrCode.dto.StudentDto;
import topg.QrCode.model.Student;
import topg.QrCode.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(StudentDto studentDto) {
        // Use the builder pattern to create a new Student instance
        Student student = Student.builder()
                .name(studentDto.name())   // Corrected to use name() since StudentDto is a record
                .email(studentDto.email()) // Corrected to use email() since StudentDto is a record
                .mobile(studentDto.mobile()) // Assuming your Student has a mobile field
                // Set other fields from studentDto as necessary
                .build();

        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id); // Directly return the Optional
    }
}

package topg.QrCode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import topg.QrCode.Utils.QRcodes;
import topg.QrCode.dto.StudentDto;
import topg.QrCode.model.Student;
import topg.QrCode.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

 if(students.size() != 0){
     // Loop through each student to generate a QR code
     for (Student student : students) {
         QRcodes.codeGenerator(student);  // Generate QR code for each student
     }
 }

        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<String> postStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Student added successfully with ID: " + student.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable("id") Integer id) {
        Optional<Student> optionalStudent = studentService.findStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            StudentDto studentDto = new StudentDto(student.getName(), student.getEmail(), student.getMobile());
            return ResponseEntity.ok(studentDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Or a custom error message
        }
    }
}

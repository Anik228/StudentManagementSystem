package com.example.StudentManagement.Controller;
import com.example.StudentManagement.Dto.StudentDto;
import com.example.StudentManagement.Dto.StudentResponseDto;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/CreateStudent")
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentDto dto) {
        StudentResponseDto saved = studentService.createStudent(dto);
        return ResponseEntity.ok(saved);
    }



    @PutMapping("/UpdateStudent")
    public ResponseEntity<Student> updateStudent(
            @RequestParam("student_id") Long studentIdStr,
            @RequestBody StudentDto studentDto) {


        Student updated = studentService.updateStudent(studentIdStr, studentDto);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteStudent")
    public ResponseEntity<Map<String, String>> deleteStudent(@RequestParam("student_id") Long studentId) {
        boolean deleted = studentService.deleteStudent(studentId);

        Map<String, String> response = new HashMap<>();
        if (deleted) {
            response.put("status", "success");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "failed");
            return ResponseEntity.status(404).body(response);
        }
    }

}


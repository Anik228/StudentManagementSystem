package com.example.StudentManagement.Controller;
import com.example.StudentManagement.Dto.*;
import com.example.StudentManagement.Model.Course;
import com.example.StudentManagement.Model.Faculty;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Services.CourseService;
import com.example.StudentManagement.Services.FacultyService;
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
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable long id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/CreateCourse")
    public ResponseEntity<CourseAddResponseDto> createCourse(@RequestBody CourseAddDto dto) {
        CourseAddResponseDto saved = courseService.createCourse(dto);
        return ResponseEntity.ok(saved);
    }


    @PutMapping("/UpdateCourse")
    public ResponseEntity<Course> updateCourse(
            @RequestParam("course_id") Long courseIdStr,
            @RequestBody CourseAddResponseDto courseAddDto) {

        Course updated = courseService.updateCourse(courseIdStr,courseAddDto);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteCourse")
    public ResponseEntity<Map<String, String>> deleteCourse(@RequestParam("course_id") Long courseId) {
        boolean deleted = courseService.deleteCourse(courseId);

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


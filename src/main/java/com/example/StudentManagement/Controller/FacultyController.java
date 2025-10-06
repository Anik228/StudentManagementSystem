package com.example.StudentManagement.Controller;
import com.example.StudentManagement.Dto.FacultyAddDto;
import com.example.StudentManagement.Dto.FacultyResponseDto;
import com.example.StudentManagement.Dto.StudentDto;
import com.example.StudentManagement.Dto.StudentResponseDto;
import com.example.StudentManagement.Model.Faculty;
import com.example.StudentManagement.Model.Student;
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
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/all")
    public List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculty();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable String id){
        return facultyService.getFacultyById(id);
    }

    @PostMapping("/CreateFaculty")
    public ResponseEntity<FacultyResponseDto> createFaculty(@RequestBody FacultyAddDto dto) {
        FacultyResponseDto saved = facultyService.createFaculty(dto);
        return ResponseEntity.ok(saved);
    }


    @PutMapping("/UpdateFaculty")
    public ResponseEntity<Faculty> updateFaculty(
            @RequestParam("faculty_id") Long facultyIdStr,
            @RequestBody FacultyAddDto facultyAddDto) {

        Faculty updated = facultyService.updateFaculty(facultyIdStr,facultyAddDto);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteFaculty")
    public ResponseEntity<Map<String, String>> deleteStudent(@RequestParam("faculty_id") Long facultyId) {
        boolean deleted = facultyService.deleteFaculty(facultyId);

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


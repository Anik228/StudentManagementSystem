package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dto.FacultyAddDto;
import com.example.StudentManagement.Dto.FacultyResponseDto;
import com.example.StudentManagement.Dto.StudentDto;
import com.example.StudentManagement.Dto.StudentResponseDto;
import com.example.StudentManagement.Model.Faculty;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.FacultyRepository;
import com.example.StudentManagement.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Optional;


@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    public List<Faculty> getAllFaculty() { return facultyRepository.findAll();}
    public List<Faculty> getAllFaculty() {
    return facultyRepository.findAll(Sort.by(Sort.Direction.ASC, "makeDt"));
    }

    public Faculty getFacultyById (String id){ return facultyRepository.findByFacultyId(id).orElse(null);}


    @Transactional
    public FacultyResponseDto createFaculty(FacultyAddDto dto) {
        Faculty faculty = new Faculty();
        faculty.setName(dto.getName());
        faculty.setDepartment(dto.getDepartment());
        faculty.setFACULTY_IN(dto.getFaculty_in());

        String year = String.valueOf(java.time.Year.now().getValue());
        //String semesterCode = mapSemesterToCode(student.getSemester());
        String deptCode = mapDepartmentToCode(faculty.getDepartment());

        //String semester = student.getSemester() + "-" + year;
        int random = (int) (Math.random() * 9000) + 1000;

        String plainPassword = UUID.randomUUID().toString().replace("-", "").substring(0, 16);

        String facultyId = year + "-" + deptCode + "-" + random;
        faculty.setFacultyId(facultyId);


        faculty.setMake_dt(new java.util.Date());
        faculty.setUpdate_dt(new java.util.Date());
        faculty.setPassword(passwordEncoder.encode(plainPassword));

        faculty = facultyRepository.save(faculty);

        return new FacultyResponseDto(
                faculty.getName(),
                faculty.getDepartment(),
                faculty.getFacultyId(),
                faculty.getMake_dt(),
                faculty.getUpdate_dt(),
                plainPassword,
                faculty.getFACULTY_IN()

        );
    }


    private String mapDepartmentToCode(String department) {
        if (department == null) return "99";
        switch (department.toUpperCase()) {
            case "CSE": return "60";
            case "EEE": return "50";
            case "BBA": return "10";
            default:    return "99";
        }
    }

    @Transactional
    public Faculty updateFaculty(Long id, FacultyAddDto dto) {
        Faculty faculty = facultyRepository.findById(id).orElse(null);

        if (faculty != null) {
            faculty.setName(dto.getName());
            faculty.setDepartment(dto.getDepartment());
            faculty.setFACULTY_IN(dto.getFaculty_in());

            return facultyRepository.save(faculty);
        } else {
            return null;
        }
    }


    public boolean deleteFaculty(Long facultyId) {
        Faculty facExist = facultyRepository.findById(facultyId).orElse(null);
        if (facExist != null) {
            facultyRepository.deleteById(facultyId);
            return true;
        } else {
            return false;
        }
    }


}

package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dto.StudentDto;
import com.example.StudentManagement.Dto.StudentResponseDto;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Student> getAllStudents() { return studentRepository.findAll();}

    public Student getStudentById (Long id){ return studentRepository.findById(id).orElse(null);}

//    @Transactional
//    public Student createStudent(StudentDto dto) {
//        Student student = new Student();
//        student.setName(dto.getName());
//        student.setDepartment(dto.getDepartment());
//        student.setCgpa(dto.getCgpa());
//        student.setTotal_credit(dto.getTotalCredit());
//        student.setEarn_credit(dto.getEarnCredit());
//        student.setSemester(dto.getSemester());
//
//        String year = String.valueOf(java.time.Year.now().getValue());
//        String semesterCode = mapSemesterToCode(student.getSemester());
//        String deptCode = mapDepartmentToCode(student.getDepartment());
//
//        String semester = student.getSemester() + "-" + year;
//        int random = (int) (Math.random() * 900) + 100;
//
//        String password = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
//
//        String studentId = year + "-" + semesterCode + "-" + deptCode + "-" + random;
//        student.setStudent_id(studentId);
//        student.setSemester(semester);
//
//        student.setMake_dt(new java.util.Date());
//        student.setUpdate_dt(new java.util.Date());
//        student.setPassword(passwordEncoder.encode(password));
//
//        return studentRepository.save(student);
//    }

    @Transactional
    public StudentResponseDto createStudent(StudentDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setDepartment(dto.getDepartment());
        student.setCgpa(dto.getCgpa());
        student.setTotal_credit(dto.getTotalCredit());
        student.setEarn_credit(dto.getEarnCredit());
        student.setSemester(dto.getSemester());

        String year = String.valueOf(java.time.Year.now().getValue());
        String semesterCode = mapSemesterToCode(student.getSemester());
        String deptCode = mapDepartmentToCode(student.getDepartment());

        String semester = student.getSemester() + "-" + year;
        int random = (int) (Math.random() * 900) + 100;

        String plainPassword = UUID.randomUUID().toString().replace("-", "").substring(0, 16);

        String studentId = year + "-" + semesterCode + "-" + deptCode + "-" + random;
        student.setStudent_id(studentId);
        student.setSemester(semester);

        student.setMake_dt(new java.util.Date());
        student.setUpdate_dt(new java.util.Date());
        student.setPassword(passwordEncoder.encode(plainPassword)); // store hashed password

        student = studentRepository.save(student);

        return new StudentResponseDto(

                student.getName(),
                student.getStudent_id(),
                student.getSemester(),
                student.getDepartment(),
                student.getCgpa(),
                student.getTotal_credit(),
                student.getEarn_credit(),
                student.getMake_dt(),
                student.getUpdate_dt(),
                plainPassword // return plain password
        );
    }




    private String mapSemesterToCode(String semester) {
        if (semester == null) return "0";
        switch (semester.toLowerCase()) {
            case "spring": return "1";
            case "summer": return "2";
            case "fall":   return "3";
            default:       return "0";
        }
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
    public Student updateStudent(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(dto.getName());
            student.setSemester(dto.getSemester());
            student.setDepartment(dto.getDepartment());
            student.setCgpa(dto.getCgpa());
            student.setTotal_credit(dto.getTotalCredit());
            student.setEarn_credit(dto.getEarnCredit());
            student.setUpdate_dt(new java.util.Date());

            return studentRepository.save(student);
        } else {
            return null;
        }
    }


    public boolean deleteStudent(Long studentId) {
        Student studExist = studentRepository.findById(studentId).orElse(null);
        if (studExist != null) {
            studentRepository.deleteById(studentId);
            return true;
        } else {
            return false;
        }
    }


}

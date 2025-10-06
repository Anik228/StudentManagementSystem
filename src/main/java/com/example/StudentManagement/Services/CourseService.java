package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dto.*;
import com.example.StudentManagement.Model.Course;
import com.example.StudentManagement.Model.Faculty;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.CourseRepository;
import com.example.StudentManagement.Repository.FacultyRepository;
import com.example.StudentManagement.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<Course> getAllCourse() { return courseRepository.findAll();}

    public Course getCourseById (Long id){ return courseRepository.findById(id).orElse(null);}



    @Transactional
    public CourseAddResponseDto createCourse(CourseAddDto dto) {

        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setDepartReq(dto.getDepartReq());
        course.setMinimumCreditReq(dto.getMinimumCreditReq());

        course.setMake_dt(new java.util.Date());
        course.setUpdate_dt(new java.util.Date());


        course = courseRepository.save(course);

        return new CourseAddResponseDto(
                course.getCourseName(),
                course.getMinimumCreditReq(),
                course.getDepartReq(),
                course.getMake_dt(),
                course.getUpdate_dt()
        );

    }


    @Transactional
    public Course updateCourse(Long id,CourseAddResponseDto dto) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {
            course.setCourseName(dto.getCourseName());
            course.setDepartReq(dto.getDepartReq());
            course.setMinimumCreditReq(dto.getMinimumCreditReq());
            course.setUpdate_dt(new java.util.Date());

            return courseRepository.save(course);
        } else {
            return null;
        }
    }


    public boolean deleteCourse(Long courseId) {
         Course courseExist = courseRepository.findById(courseId).orElse(null);
        if (courseExist != null) {
            courseRepository.deleteById(courseId);
            return true;
        } else {
            return false;
        }
    }


}

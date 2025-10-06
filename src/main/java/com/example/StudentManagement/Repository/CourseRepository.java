package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Model.Course;
import com.example.StudentManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT s FROM Course s WHERE s.id = :courseId")
    Optional<Student> findByCourseId(@Param("courseId") String courseId);

}
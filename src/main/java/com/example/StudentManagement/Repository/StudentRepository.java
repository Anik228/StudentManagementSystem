package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.student_id = :studentId")
    Optional<Student> findByStudentId(@Param("studentId") String studentId);

}
package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query("SELECT f FROM Faculty f WHERE f.faculty_id = :facultyId")
    Optional<Faculty> findByFacultyId(@Param("facultyId") String facultyId);

}

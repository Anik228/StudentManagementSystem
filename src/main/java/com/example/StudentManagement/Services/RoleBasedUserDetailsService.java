package com.example.StudentManagement.Services;

import com.example.StudentManagement.Dto.AuthRequestDto;
import com.example.StudentManagement.Model.Faculty;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository.AdminRepository;
import com.example.StudentManagement.Repository.FacultyRepository;
import com.example.StudentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collections;

@Service
public class RoleBasedUserDetailsService {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private FacultyRepository facultyRepo;
    @Autowired
    private AdminRepository adminRepo;

//    @Autowired
//    private FacultyRepository facultyRepo;
//    @Autowired
//    private AdminRepository adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUser(AuthRequestDto request) {
        String role = request.getRole().toUpperCase();
        String userid = request.getUserid();

        switch (role) {
            case "STUDENT":
                Student student = studentRepo.findByStudentId(userid)
                        .orElseThrow(() -> new UsernameNotFoundException("Student not found"));
                return new org.springframework.security.core.userdetails.User(
                        student.getStudent_id(),
                        student.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_STUDENT"))
                );

            case "FACULTY":
                Faculty faculty = facultyRepo.findByFacultyId(userid)
                        .orElseThrow(() -> new UsernameNotFoundException("Faculty not found"));
                return new org.springframework.security.core.userdetails.User(
                        faculty.getFacultyId(),
                        faculty.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_FACULTY"))
                );

            case "ADMIN":
                AdminRepository.AdminData admin = adminRepo.findAdminById(userid)
                        .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

                return new org.springframework.security.core.userdetails.User(
                        admin.getAdminId(),
                        admin.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
                );



            default:
                throw new UsernameNotFoundException("Role not recognized");
        }
    }
}


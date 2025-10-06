package com.example.StudentManagement.Dto;
import jakarta.persistence.Column;

import java.util.Date;

public class FacultyResponseDto {

    private String name;
    private String department;
    private String facultyId;
    private Date make_dt;
    private Date update_dt;
    private String password;
    private String faculty_in;

    public FacultyResponseDto(String name, String department, String facultyId,
                              Date make_dt, Date update_dt, String password,
                              String faculty_in) {
        this.name = name;
        this.department = department;
        this.facultyId = facultyId;
        this.make_dt = make_dt;
        this.update_dt = update_dt;
        this.password = password;
        this.faculty_in = faculty_in;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public Date getMake_dt() {
        return make_dt;
    }

    public void setMake_dt(Date make_dt) {
        this.make_dt = make_dt;
    }

    public Date getUpdate_dt() {
        return update_dt;
    }

    public void setUpdate_dt(Date update_dt) {
        this.update_dt = update_dt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty_in() {
        return faculty_in;
    }

    public void setFaculty_in(String faculty_in) {
        this.faculty_in = faculty_in;
    }
}

package com.example.StudentManagement.Dto;

public class FacultyAddDto {

    private String name;
    private String department;
    private String faculty_in;

    public FacultyAddDto(String name, String department, String faculty_in) {
        this.name = name;
        this.department = department;
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

    public String getFaculty_in() {
        return faculty_in;
    }

    public void setFaculty_in(String faculty_in) {
        this.faculty_in = faculty_in;
    }
}

package com.example.StudentManagement.Dto;

import java.util.Date;

public class StudentResponseDto {

    private String name;
    private String student_id;
    private String semester;
    private String department;
    private Double cgpa;
    private Double total_credit;
    private Double earn_credit;
    private Date make_dt;
    private Date update_dt;
    private String password;

    public StudentResponseDto(String name, String student_id, String semester, String department, Double cgpa, Double total_credit, Double earn_credit, Date make_dt, Date update_dt, String password) {

        this.name = name;
        this.student_id = student_id;
        this.semester = semester;
        this.department = department;
        this.cgpa = cgpa;
        this.total_credit = total_credit;
        this.earn_credit = earn_credit;
        this.make_dt = make_dt;
        this.update_dt = update_dt;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Double getTotal_credit() {
        return total_credit;
    }

    public void setTotal_credit(Double total_credit) {
        this.total_credit = total_credit;
    }

    public Double getEarn_credit() {
        return earn_credit;
    }

    public void setEarn_credit(Double earn_credit) {
        this.earn_credit = earn_credit;
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
}

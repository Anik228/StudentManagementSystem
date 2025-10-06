package com.example.StudentManagement.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "minimum_credit_req")
    private Double minimumCreditReq;

    @Column(name = "depart_req", length = 100)
    private String departReq;

    @Column(name = "make_dt")
    private Date make_dt;

    @Column(name = "update_dt")
    private Date update_dt;

    public Course(Long id, String courseName, Double minimumCreditReq, String departReq, Date make_dt, Date update_dt) {
        this.id = id;
        this.courseName = courseName;
        this.minimumCreditReq = minimumCreditReq;
        this.departReq = departReq;
        this.make_dt = make_dt;
        this.update_dt = update_dt;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getMinimumCreditReq() {
        return minimumCreditReq;
    }

    public void setMinimumCreditReq(Double minimumCreditReq) {
        this.minimumCreditReq = minimumCreditReq;
    }

    public String getDepartReq() {
        return departReq;
    }

    public void setDepartReq(String departReq) {
        this.departReq = departReq;
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
}

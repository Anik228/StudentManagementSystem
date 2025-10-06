package com.example.StudentManagement.Dto;

import java.util.Date;

public class CourseAddResponseDto {

    private String courseName;
    private Double minimumCreditReq;
    private String departReq;
    private Date make_dt;
    private Date update_dt;



    public CourseAddResponseDto() {
    }

    public CourseAddResponseDto(String courseName, Double minimumCreditReq, String departReq, Date make_dt, Date update_dt) {
        this.courseName = courseName;
        this.minimumCreditReq = minimumCreditReq;
        this.departReq = departReq;
        this.make_dt = make_dt;
        this.update_dt = update_dt;
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

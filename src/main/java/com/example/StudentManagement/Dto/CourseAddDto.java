package com.example.StudentManagement.Dto;

public class CourseAddDto {

    private String courseName;
    private Double minimumCreditReq;
    private String departReq;



    public CourseAddDto() {
    }

    public CourseAddDto(String courseName, Double minimumCreditReq, String departReq, Long facultyId, String facultyName) {
        this.courseName = courseName;
        this.minimumCreditReq = minimumCreditReq;
        this.departReq = departReq;

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


}

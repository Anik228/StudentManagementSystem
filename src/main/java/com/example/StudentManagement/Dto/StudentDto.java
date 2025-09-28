package com.example.StudentManagement.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDto {

    private String name;

    @JsonProperty("student_id")
    private String studentId;

    private String semester;

    private String department;

    private Double cgpa;

    @JsonProperty("total_credit")
    private Double totalCredit;

    @JsonProperty("earn_credit")
    private Double earnCredit;

    public StudentDto() {}

    public StudentDto(String name, String studentId, String semester,
                      String department, Double cgpa, Double totalCredit, Double earnCredit) {
        this.name = name;
        this.studentId = studentId;
        this.semester = semester;
        this.department = department;
        this.cgpa = cgpa;
        this.totalCredit = totalCredit;
        this.earnCredit = earnCredit;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getCgpa() { return cgpa; }
    public void setCgpa(Double cgpa) { this.cgpa = cgpa; }

    public Double getTotalCredit() { return totalCredit; }
    public void setTotalCredit(Double totalCredit) { this.totalCredit = totalCredit; }

    public Double getEarnCredit() { return earnCredit; }
    public void setEarnCredit(Double earnCredit) { this.earnCredit = earnCredit; }
}

package com.example.StudentManagement.Model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "student")

public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "student_id", unique = true, nullable = false)
    private String student_id;

    @Column(name = "semester")
    private String semester;

    @Column(name = "department")
    private String department;

    @Column(name = "cgpa")
    private Double cgpa;

    @Column(name = "total_credit")
    private Double total_credit;

    @Column(name = "earn_credit")
    private Double earn_credit;

    @Column(name = "make_dt")
    private Date make_dt;

    @Column(name = "update_dt")
    private Date update_dt;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;


//    @OneToOne(mappedBy = "accounts")
//    private Employee employee;


    public Student()  {
        //default const.
    }

    public Student(String name, String student_id, String semester,
                   String department, Double cgpa, Double total_credit, Double earn_credit, Date make_dt
    ,Date update_dt,String password) {
        this.name = name;
        this.student_id = student_id;
        this.semester = semester;
        this.department = department;
        this.cgpa = cgpa;
        this.total_credit = total_credit;
        this.earn_credit = earn_credit;
        this.make_dt= make_dt;
        this.update_dt=update_dt;
        this.password=password;
    }

    public Long getId() {
        return id;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public Double getTotal_credit() {
        return total_credit;
    }

    public Double getEarn_credit() {
        return earn_credit;
    }

    public String getDepartment() {
        return department;
    }

    public String getSemester() {
        return semester;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public void setTotal_credit(Double total_credit) {
        this.total_credit = total_credit;
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
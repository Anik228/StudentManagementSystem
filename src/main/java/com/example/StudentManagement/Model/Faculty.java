package com.example.StudentManagement.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "faculty_id", unique = true, nullable = false)
    private String faculty_id;

    @Column(name = "make_dt")
    private Date makeDt;

    @Column(name = "update_dt")
    private Date updateDt;

    @Column(name = "password")
    private String password;

    @Column(name = "FACULTY_IN")
    private String FACULTY_IN;

    @Enumerated(EnumType.STRING)
    private Role role = Role.FACULTY;

    public Faculty(Long id, String name, String department, String facultyId, Date make_dt, Date update_dt, String password,
                   String FACULTY_IN, Role role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.faculty_id = facultyId;
        this.makeDt = make_dt;
        this.updateDt = update_dt;
        this.password = password;
        this.FACULTY_IN = FACULTY_IN;

    }

    public Faculty() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return faculty_id;
    }

    public void setFacultyId(String facultyId) {
        this.faculty_id = facultyId;
    }

    public Date getMake_dt() {
        return makeDt;
    }

    public void setMake_dt(Date make_dt) {
        this.makeDt = make_dt;
    }

    public Date getUpdate_dt() {
        return updateDt;
    }

    public void setUpdate_dt(Date update_dt) {
        this.updateDt = update_dt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFACULTY_IN() {
        return FACULTY_IN;
    }

    public void setFACULTY_IN(String FACULTY_IN) {
        this.FACULTY_IN = FACULTY_IN;
    }
}

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long faculty_id;
    private String name;
    private String designation;
    private String subject;
    private String dept;
    private String mobileno;

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", faculty_id=" + faculty_id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", subject='" + subject + '\'' +
                ", dept='" + dept + '\'' +
                ", mobileno='" + mobileno + '\'' +
                '}';
    }
    public Faculty(){}

    public Faculty(Long id, Long faculty_id, String name, String designation, String subject, String dept, String mobileno) {
        this.id = id;
        this.faculty_id = faculty_id;
        this.name = name;
        this.designation = designation;
        this.subject = subject;
        this.dept = dept;
        this.mobileno = mobileno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}

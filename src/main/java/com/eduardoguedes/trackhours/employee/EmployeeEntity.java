package com.eduardoguedes.trackhours.employee;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epl_id", nullable = false)
    private Integer id;

    @Column(name = "epl_name", nullable = false)
    private String name;

    @Column(name = "epl_document", nullable = false)
    private String document;

    @Column(name = "epl_date_of_birth", nullable = false)
    private Date dateOfBirth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

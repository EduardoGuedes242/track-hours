package com.eduardoguedes.trackhours.employee;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epl_id")
    private Integer id;

    @Column(name = "tnt_id")
    private Integer tenantId;

    @Column(name = "epl_name")
    private String name;

    @Column(name = "epl_document")
    private String document;

    @Column(name = "epl_date_of_birth")
    private Date dateOfBirth;

    @Column(name = "epl_password")
    private String password;

    @Column(name = "epl_active")
    private Boolean active;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer id, Integer tenantId, String name, String document, Date dateOfBirth, String password) {
        this.id = id;
        this.tenantId = tenantId;
        this.name = name;
        this.document = document;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

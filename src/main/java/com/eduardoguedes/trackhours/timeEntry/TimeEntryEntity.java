package com.eduardoguedes.trackhours.timeEntry;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name = "time_entry")
@Entity
public class TimeEntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tme_id")
    private Integer id;

    @Column(name = "epl_id")
    private Integer employeeId;

    @Column(name = "tme_timestamp")
    private Date dateTimestemp;

    @Column(name = "tme_observation")
    private String observation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateTimestemp() {
        return dateTimestemp;
    }

    public void setDateTimestemp(Date dateTimestemp) {
        this.dateTimestemp = dateTimestemp;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}


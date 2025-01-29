package com.eduardoguedes.trackhours.menagerHours.dto;

import java.util.List;

public class EmployeeMenageDTO {
    private int eplId;
    private String eplName;
    private List<TimeEntryMenageDTO> tmeEntryRecords;

    public EmployeeMenageDTO(int eplId, String eplName, List<TimeEntryMenageDTO> tmeEntryRecords) {
        this.eplId = eplId;
        this.eplName = eplName;
        this.tmeEntryRecords = tmeEntryRecords;
    }

    public EmployeeMenageDTO() {}

    public int getEplId() {
        return eplId;
    }

    public void setEplId(int eplId) {
        this.eplId = eplId;
    }

    public String getEplName() {
        return eplName;
    }

    public void setEplName(String eplName) {
        this.eplName = eplName;
    }

    public List<TimeEntryMenageDTO> getTmeEntryRecords() {
        return tmeEntryRecords;
    }

    public void setTmeEntryRecords(List<TimeEntryMenageDTO> tmeEntryRecords) {
        this.tmeEntryRecords = tmeEntryRecords;
    }
}

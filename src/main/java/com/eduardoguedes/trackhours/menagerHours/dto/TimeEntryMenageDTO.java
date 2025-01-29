package com.eduardoguedes.trackhours.menagerHours.dto;

public class TimeEntryMenageDTO  {
    private String tmeDate;
    private String timeEntry1;
    private String timeEntry2;
    private String timeEntry3;
    private String timeEntry4;
    private String totalHours;

    public TimeEntryMenageDTO(String tmeDate, String timeEntry1, String timeEntry2, String timeEntry3, String timeEntry4, String totalHours) {
        this.tmeDate = tmeDate;
        this.timeEntry1 = timeEntry1;
        this.timeEntry2 = timeEntry2;
        this.timeEntry3 = timeEntry3;
        this.timeEntry4 = timeEntry4;
        this.totalHours = totalHours;
    }

    public TimeEntryMenageDTO() {}

    public String getTmeDate() {
        return tmeDate;
    }

    public void setTmeDate(String tmeDate) {
        this.tmeDate = tmeDate;
    }

    public String getTimeEntry1() {
        return timeEntry1;
    }

    public void setTimeEntry1(String timeEntry1) {
        this.timeEntry1 = timeEntry1;
    }

    public String getTimeEntry2() {
        return timeEntry2;
    }

    public void setTimeEntry2(String timeEntry2) {
        this.timeEntry2 = timeEntry2;
    }

    public String getTimeEntry3() {
        return timeEntry3;
    }

    public void setTimeEntry3(String timeEntry3) {
        this.timeEntry3 = timeEntry3;
    }

    public String getTimeEntry4() {
        return timeEntry4;
    }

    public void setTimeEntry4(String timeEntry4) {
        this.timeEntry4 = timeEntry4;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }
}

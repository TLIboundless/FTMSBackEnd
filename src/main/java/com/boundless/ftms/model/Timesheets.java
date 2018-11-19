package com.boundless.ftms.model;

import javax.persistence.*;

import java.sql.*;

@Entity
public class Timesheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private int timesheet_id;

    @Column(name = "worker_id")
    private int worker_id;

    @Column(name = "job_id")
    private int job_id;

    @Column(name = "time_submitted")
    private Timestamp time_submitted = null;

    @Column(name = "approval_status")
    private String approval_status;

    @Column(name = "rejection_reason")
    private String rejection_reason;

    @Column(name = "time_approved")
    private Timestamp time_approved = null;

    public Timesheets() {
    }

    public Timesheets(int worker_id, int job_id, Timestamp time_submitted, String approval_status, String rejection_reason,
                      Timestamp time_approved) {
        this.worker_id = worker_id;
        this.job_id = job_id;
        this.time_submitted = time_submitted;
        this.approval_status = approval_status;
        this.rejection_reason = rejection_reason;
        this.time_approved = time_approved;
    }

    public int getTimesheet_id() {
        return timesheet_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public Timestamp getTime_submitted() {
        return time_submitted;
    }

    public String getApproval_status() {
        return approval_status;
    }

    public String getRejection_reason() {
        return rejection_reason;
    }

    public Timestamp getTime_approved() {
        return time_approved;
    }

    public void setTimesheet_id(int timesheet_id) { this.timesheet_id = timesheet_id; }

    public void setWorker_id(int worker_id) { this.worker_id = worker_id; }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setTime_submitted(Timestamp time_submitted) {
        this.time_submitted = time_submitted;
    }

    public void setApproval_status(String approval_status) {
        this.approval_status = approval_status;
    }

    public void setRejection_reason(String rejection_reason) {
        this.rejection_reason = rejection_reason;
    }

    public void setTime_approved(Timestamp time_approved) {
        this.time_approved = time_approved;
    }
}

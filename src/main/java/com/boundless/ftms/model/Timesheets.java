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

    public int getTimesheetId() {
        return timesheet_id;
    }

    public int getWorkerId() {
        return worker_id;
    }

    public int getJobId() {
        return job_id;
    }

    public Timestamp getTimeSubmitted() {
        return time_submitted;
    }

    public String getApprovalStatus() {
        return approval_status;
    }

    public String getRejectionReason() {
        return rejection_reason;
    }

    public Timestamp getTimeApproved() {
        return time_approved;
    }

    public void setTimesheetId(int timesheet_id) { this.timesheet_id = timesheet_id; }

    public void setWorkerId(int worker_id) { this.worker_id = worker_id; }

    public void setJobId(int job_id) {
        this.job_id = job_id;
    }

    public void setTimeSubmitted(Timestamp time_submitted) {
        this.time_submitted = time_submitted;
    }

    public void setApprovalStatus(String approval_status) {
        this.approval_status = approval_status;
    }

    public void setRejectionReason(String rejection_reason) {
        this.rejection_reason = rejection_reason;
    }

    public void setTimeApproved(Timestamp time_approved) {
        this.time_approved = time_approved;
    }
}

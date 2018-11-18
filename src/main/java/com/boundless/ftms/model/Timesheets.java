package com.boundless.ftms.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;

import java.sql.*;
import java.time.LocalDateTime;

@Entity
public class Timesheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private int timesheetID;

    @Column(name = "worker_id")
    private int workerID;

    @Column(name = "job_id")
    private int jobID;

    @Column(name = "time_submitted")
    private Timestamp timeSubmitted = null;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "time_approved")
    private Timestamp timeApproved = null;

    public Timesheets() {
    }

    public Timesheets(int workerID, int jobID, Timestamp timeSubmitted, String approvalStatus, String rejectionReason,
                      Timestamp timeApproved) {
        this.workerID = workerID;
        this.jobID = jobID;
        this.timeSubmitted = timeSubmitted;
        this.approvalStatus = approvalStatus;
        this.rejectionReason = rejectionReason;
        this.timeApproved = timeApproved;
    }

    public int getTimesheetID() {
        return timesheetID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public int getJobID() {
        return jobID;
    }

    public Timestamp getTimeSubmitted() {
        return timeSubmitted;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Timestamp getTimeApproved() {
        return timeApproved;
    }

    public void setTimesheetID(int timesheetID) { this.timesheetID = timesheetID; }

    public void setWorkerID(int workerID) { this.workerID = workerID; }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setTimeSubmitted(Timestamp timeSubmitted) {
        this.timeSubmitted = timeSubmitted;
    }

//    public void setApprovalStatus(String approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }

    public void approve() {
        LocalDateTime localDateTime = LocalDateTime.now();
        this.approvalStatus = "Approved";
        this.timeApproved = Timestamp.valueOf(localDateTime);
    }

    public void reject(String rejectionReason) {
        this.rejectionReason = rejectionReason;
        this.approvalStatus = "Rejected";
    }

//    public void setRejectionReason(String rejectionReason) {
//        this.rejectionReason = rejectionReason;
//    }

//    public void setTimeApproved(Timestamp timeApproved) {
//        this.timeApproved = timeApproved;
//    }
}

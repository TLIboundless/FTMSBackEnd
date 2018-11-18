package com.boundless.ftms.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.*;
import java.sql.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskID;

    @Column(name = "job_id")
    private int jobID;

    @Column(name = "start_time")
    private Timestamp startTime = null;

    @Column(name = "end_time")
    private Timestamp endTime = null;

    @Column(name = "duration")
    private int duration; // in minutes

    public Task() {}

    public Task(int jobID, Timestamp startTime, Timestamp endTime, int duration) {
        this.duration = duration;
        this.jobID = jobID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
}


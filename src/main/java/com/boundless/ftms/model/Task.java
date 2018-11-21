package com.boundless.ftms.model;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int task_id;

    @Column(name = "job_id")
    private int job_id;

    @Column(name = "start_time")
    private Timestamp start_time = null;

    @Column(name = "end_time")
    private Timestamp end_time = null;

    @Column(name = "duration")
    private int duration; // in minutes

    @Column(name = "task_name")
    private String name;

    public Task() {}

    public Task(int task_id, int job_id, Timestamp start_time, Timestamp end_time, int duration, String name) {
        this.task_id = task_id;
        this.duration = duration;
        this.job_id = job_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.name = name;
    }


    public int getJobId() {
        return job_id;
    }

    public void setJobId(int job_id) {
        this.job_id = job_id;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getEndTime() {
        return end_time;
    }

    public void setEndTime(Timestamp end_time) {
        this.end_time = end_time;
    }

    public void setStartTime(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getStartTime() {
        return start_time;
    }

    public int getTaskId() {
        return task_id;
    }

    public void setTaskId(int task_id) {
        this.task_id = task_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


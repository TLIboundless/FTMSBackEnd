package com.boundless.ftms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.*;

@Entity
public class Timesheets {

    @Id
    @GeneratedValue
    @Column(name = "timesheet_id")
    private String name;

    @Column(name = "start_time")
    private Timestamp startTime = null;

    @Column(name = "end_time")
    private Timestamp endTime = null;

    @Column(name = "worker_id")
    private int workerID;

    @Column(name = "job_id")
    private int jobID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

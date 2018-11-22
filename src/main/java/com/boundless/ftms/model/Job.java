package com.boundless.ftms.model;

import javax.persistence.*;

@Entity
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "job_id")
    private int job_id;
    @Column (name = "worker_id")
    private int worker_id;
    @Column (name = "supervisor_id")
    private int supervisor_id;
    @Column (name = "workorder_id")
    private int workorder_id;
    @Column(name = "job_name")
    private String job_name;

    public Job() {}

    public Job(int job_id, int worker_id, int workorder_id, int supervisor_id, String job_name){
        this.job_id = job_id;
        this.worker_id = worker_id;
        this.workorder_id = workorder_id;
        this.supervisor_id = supervisor_id;
        this.job_name = job_name;
    }
    public int getJobID() {
        return job_id;
    }

    public void setJobID(int job_id) {
        this.job_id = job_id;
    }

    public int getWorkerID() {
        return worker_id;
    }

    public void setWorkerID(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getSupervisorID() {
        return supervisor_id;
    }

    public void setSupervisorID(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public int getWorkorderID() {
        return workorder_id;
    }

    public void setWorkorderID(int workorder_id) {
        this.workorder_id = workorder_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }
}

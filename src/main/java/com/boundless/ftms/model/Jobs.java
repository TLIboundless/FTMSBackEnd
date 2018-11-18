package com.boundless.ftms.model;

import javax.persistence.*;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "worker_id")
    private int workerID;
    @Column (name = "supervisor_id")
    private int supervisorID;
    @Column (name = "workorder_id")
    private int workorderID;

    public Jobs() {}

    public Jobs(int workerID, int workorderID, int superintendedID){
        this.workerID = workerID;
        this.workorderID = workorderID;
        this.supervisorID = superintendedID;
    }
    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(int supervisorID) {
        this.supervisorID = supervisorID;
    }

    public int getWorkorderID() {
        return workorderID;
    }

    public void setWorkorderID(int workorderID) {
        this.workorderID = workorderID;
    }


}

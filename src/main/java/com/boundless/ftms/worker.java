package com.boundless.ftms;
import java.util.ArrayList;
// need to keep track of new workers, need to be added to database!
// getters and setters depending on sprint youre working on add what is needed.
public class worker extends user {
    private static ArrayList<WorkOrder> workOrderlist;
    private String name;
    private String email;
    private Type workerType;
    private boolean working;

    // Types of employees - can be edited.
    private enum Type { Welder, Supervisor}


    public worker(String name, String contactInfo){
        this.name = name;
        this.email = contactInfo;
        workOrderlist = new ArrayList<WorkOrder>(3);
        working = false;
    }

    public void addWorkOrder(WorkOrder newWorkOrder){
        if (!working){
            working = true;
        }
        if(workOrderlist.size() <3){
            workOrderlist.add(newWorkOrder);}
    }
    public void removeWorkOrder(WorkOrder newWorkOrder) {
        if (workOrderlist.contains(newWorkOrder)){
            workOrderlist.remove(newWorkOrder);
        }
    }
}

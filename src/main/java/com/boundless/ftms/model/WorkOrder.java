package com.boundless.ftms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkOrder {
/*
    static List<String> allSkills = new ArrayList<String>();
    // when database and backend are connected, take from the database
    static List<String> workSites = new ArrayList<String>();
    // when database and backend are connected, take from the database
*/

    @Id
    @GeneratedValue
    @Column(name = "workorderid")
    private int id;

    @Column(name = "location")
    private String location;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "description")
    private String description;

    public WorkOrder(String location, String deadline, String description) {
        this.location = location;
        this.deadline = deadline;
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

}


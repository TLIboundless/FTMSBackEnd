package com.boundless.ftms.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class WorkOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workorder_id")
    private int id;

    @Column(name = "client_id")
    private int client_id;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "location")
    private String location;

    @Column(name = "skills")
    private String skills;

    @Column(name = "description")
    private String description;

    public WorkOrders() {}

    public WorkOrders(int client_id, Timestamp deadline, boolean completed, String location, String skills,
                      String description) {
        this.client_id = client_id;
        this.deadline = deadline;
        this.completed = completed;
        this.location = location;
        this.skills = skills;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


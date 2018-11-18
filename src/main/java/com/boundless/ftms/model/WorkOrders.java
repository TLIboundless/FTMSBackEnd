package com.boundless.ftms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class WorkOrders {
/*
    static List<String> allSkills = new ArrayList<String>();
    // when database and backend are connected, take from the database
    static List<String> workSites = new ArrayList<String>();
    // when database and backend are connected, take from the database
*/

    @Id
    @GeneratedValue
    @Column(name = "workorder_id")
    private int id;

    @Column(name = "client_id")
    private int clientId;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public void setSkills(String[] skills) {
        StringBuilder concatenatedSkills = new StringBuilder("");
        for (String skill: skills) {
            concatenatedSkills.append(skill + ",");
        }
        this.skills = concatenatedSkills.replace(concatenatedSkills.length()-1, concatenatedSkills.length(),
                "").toString();

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


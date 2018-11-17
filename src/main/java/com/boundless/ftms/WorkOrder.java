package com.boundless.ftms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorkOrder {
    static List<String> allSkills = new ArrayList<String>();
    // when database and backend are connected, take from the database
    static List<String> workSites = new ArrayList<String>();
    // when database and backend are connected, take from the database

    @Id
    @GeneratedValue
    @Column(name = "skills")
    private List<String> skills = new ArrayList<String>();

    @Column(name = "location")
    private String location;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "description")
    private String description;

    public WorkOrder(ArrayList<String> skills, String location, String deadline, String description) {
        this.skills = skills;
        this.location = location;
        this.deadline = deadline;
        this.description = description;
        workSites.add(location);

        for (int i = 0; i < skills.size(); i++) {
            if (!allSkills.contains(skills.get(i))) {
                allSkills.add(skills.get(i));
            }
        }
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
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

    public List<String> getAllSkills() {
        return allSkills;
    }

    public List<String> getWorkSites() {
        return workSites;
    }

    public List<String> getSkills() {
        return skills;
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


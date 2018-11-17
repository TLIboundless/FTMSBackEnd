package com.boundless.ftms;

import java.util.ArrayList;
import java.util.List;

public class WorkOrder {
    static List<String> allSkills = new ArrayList<String>();
    // when database and backend are connected, take from the database
    static List<String> workSites = new ArrayList<String>();
    // when database and backend are connected, take from the database

    private List<String> skills = new ArrayList<String>();

    private String location;

    private String deadline;

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


}

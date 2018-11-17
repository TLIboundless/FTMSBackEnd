package com.boundless.ftms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


// need to keep track of new workers, need to be added to database!
// getters and setters depending on sprint youre working on add what is needed.
@Entity
public class Worker {
    @Id
    @GeneratedValue
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "employeeID")
    private String workerID;
    @Column(name = "type")
    private Type workerType;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public Type getWorkerType() {
        return workerType;
    }

    public void setWorkerType(Type workerType) {
        this.workerType = workerType;
    }


    // Types of employees - can be edited.
    private enum Type {
        Welder, Supervisor
    }

    public Worker() {
    }

    public Worker(String firstName, String lastName, String workerID, Type workerType, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workerID = workerID;
        this.workerType = workerType;
        this.email = email;

    }

}

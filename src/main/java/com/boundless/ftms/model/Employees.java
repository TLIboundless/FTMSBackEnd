package com.boundless.ftms.model;

import javax.persistence.*;


// need to keep track of new workers, need to be added to database!
// getters and setters depending on sprint youre working on add what is needed.
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;

    public Employees(String lastName, String firstName, String email, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;

    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employees() {
    }

}

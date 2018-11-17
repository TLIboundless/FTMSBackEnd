package com.boundless.ftms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "clients_id")
    private int clientsID;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Client() {
    }

    public int getClientsID() {
        return clientsID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setClientsID(int clientsID) {
        this.clientsID = clientsID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

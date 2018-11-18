package com.boundless.ftms.model;

import javax.persistence.*;

@Entity
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clients_id")
    private int clientsID;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Clients() {
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

package com.boundless.ftms.model;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clients_id")
    private int clients_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Client() {}

    public Client(int clients_id, String name, String email) {
        this.clients_id = clients_id;
        this.name = name;
        this.email = email;
    }

    public int getClientsID() {
        return clients_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setClientsID(int clients_id) {
        this.clients_id = clients_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

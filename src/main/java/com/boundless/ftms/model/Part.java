package com.boundless.ftms.model;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private int part_id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private double unit_price; // in dollars

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "job_id")
    private int job_id;


    public Part() { }

    public Part(int part_id, String name, double unit_price, int quantity, int job_id) {
        this.job_id = job_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.name = name;
        this.part_id = part_id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public int getJob_id() {
        return job_id;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }
}

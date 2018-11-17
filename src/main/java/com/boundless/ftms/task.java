package com.boundless.ftms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class task {

    @Id
    @GeneratedValue
    @Column(name = "name")
    private String name;



}

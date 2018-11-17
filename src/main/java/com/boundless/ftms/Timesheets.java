package com.boundless.ftms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Timesheets {

    @Id
    @GeneratedValue
    @Column(name = "timesheet_id")
    private String name;


}

package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Employees;
import com.boundless.ftms.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = "/all")
    private List<Employees> getAll() {
        return employeesRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public List<Employees> saveToDatabase(@RequestBody final Employees employees) {
        employeesRepository.save(employees);
        return employeesRepository.findAll();
    }

}



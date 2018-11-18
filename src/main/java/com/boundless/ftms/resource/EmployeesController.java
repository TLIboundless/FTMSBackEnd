package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Employees;
import com.boundless.ftms.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Employees> getAll() {
        return employeesRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody Employees employees) {
        employeesRepository.save(employees);
        return "employees updated";
    }

}



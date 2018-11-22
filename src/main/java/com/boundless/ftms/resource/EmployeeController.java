package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Employee;
import com.boundless.ftms.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Employee> getAll() {
        return employeesRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody Employee employee) {
        employeesRepository.save(employee);
        return "employees updated";
    }

}



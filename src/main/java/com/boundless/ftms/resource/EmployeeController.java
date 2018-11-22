package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Employee;
import com.boundless.ftms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "employees updated";
    }

}



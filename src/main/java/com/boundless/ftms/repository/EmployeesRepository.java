package com.boundless.ftms.repository;
import com.boundless.ftms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
}

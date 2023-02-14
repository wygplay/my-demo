package com.wygplay.springbootwebflux.controller;

import com.wygplay.springbootwebflux.model.Employee;
import com.wygplay.springbootwebflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author wyg
 * @date 2023/2/11 0:48
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping
    public Flux<Employee> listAllEmployees() {
        return employeeRepository.listAllEmployees();
    }
}

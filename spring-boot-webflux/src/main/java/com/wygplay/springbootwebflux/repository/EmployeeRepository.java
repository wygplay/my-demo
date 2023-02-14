package com.wygplay.springbootwebflux.repository;

import com.wygplay.springbootwebflux.model.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyg
 * @date 2023/2/11 1:11
 */
@Repository
public class EmployeeRepository {
    private static  final Map<String, Employee> employees;

    static {
        employees = new HashMap<>();
        employees.put("1", new Employee(1, "Employee 1"));
        employees.put("2", new Employee(2, "Employee 2"));
        employees.put("3", new Employee(3, "Employee 3"));
        employees.put("4", new Employee(4, "Employee 4"));
        employees.put("5", new Employee(5, "Employee 5"));
        employees.put("6", new Employee(6, "Employee 6"));
        employees.put("7", new Employee(7, "Employee 7"));
        employees.put("8", new Employee(8, "Employee 8"));
        employees.put("9", new Employee(9, "Employee 9"));
        employees.put("10", new Employee(10, "Employee 10"));
    }

    public Mono<Employee> getEmployeeById(String id) {
        return Mono.just(employees.get(id));
    }

    public Flux<Employee>listAllEmployees() {
        return Flux.fromIterable(employees.values());
    }
}

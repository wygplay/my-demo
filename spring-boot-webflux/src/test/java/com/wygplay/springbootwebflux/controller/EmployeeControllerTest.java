package com.wygplay.springbootwebflux.controller;

import com.wygplay.springbootwebflux.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeControllerTest {

    private WebClient client = WebClient.create("http://localhost:28080");

    @Test
    void getEmployeeById() {
        Mono<Employee> employeeMono = client.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);
        assertEquals("Employee 1", employeeMono.block().getName());
    }

    @Test
    void listAllEmployees() {
    }
}
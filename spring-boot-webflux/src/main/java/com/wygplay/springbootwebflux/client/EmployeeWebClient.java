package com.wygplay.springbootwebflux.client;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author wyg
 * @date 2023/2/11 1:35
 */
public class EmployeeWebClient {

    private WebClient client = WebClient.create("http://localhost:28080");

}

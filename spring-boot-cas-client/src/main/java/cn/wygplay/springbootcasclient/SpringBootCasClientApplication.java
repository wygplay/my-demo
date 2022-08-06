package cn.wygplay.springbootcasclient;

import org.jasig.cas.client.boot.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasClient
public class SpringBootCasClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCasClientApplication.class, args);
    }

}

package com.wygplay.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoConfig {

    @Bean
    public DirectExchange demoDirectExchange() {
        return new DirectExchange("hmall.demo.direct");
    }

    @Bean
    public Queue demoQueue() {
        return new Queue("hmall.demo.queue");
    }

    @Bean
    public Binding demoBinding(DirectExchange demoDirectExchange, Queue demoQueue) {
        return BindingBuilder.bind(demoQueue).to(demoDirectExchange).with("demo");
    }
}

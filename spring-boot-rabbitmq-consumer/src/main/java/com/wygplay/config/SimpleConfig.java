package com.wygplay.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue("simple.queue");
    }

    @Bean
    public Queue workQueue() {
        return new Queue("work.queue");
    }
}

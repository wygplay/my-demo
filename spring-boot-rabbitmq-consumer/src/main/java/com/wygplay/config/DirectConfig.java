package com.wygplay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct exchange config
 * exchange hmall.direct
 * queue direct.queueA routingKey: blue, red, direct.queueB routingKey: blue, yellow
 * routingKey blue, red, yellow
 */
@Configuration
public class DirectConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("hmall.direct");
    }

    @Bean
    public Queue directQueueA() {
        return new Queue("direct.queueA");
    }

    @Bean
    public Queue directQueueB() {
        return new Queue("direct.queueB");
    }

    @Bean
    public Binding directBindingA(DirectExchange directExchange, Queue directQueueA) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with("blue");
    }

    @Bean
    public Binding directBindingB(DirectExchange directExchange, Queue directQueueA) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with("red");
    }

    @Bean
    public Binding directBindingC(DirectExchange directExchange, Queue directQueueB) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with("blue");
    }

    @Bean
    public Binding directBindingD(DirectExchange directExchange, Queue directQueueB) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with("yellow");
    }
}

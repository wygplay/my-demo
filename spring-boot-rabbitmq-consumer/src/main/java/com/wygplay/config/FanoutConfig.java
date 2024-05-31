package com.wygplay.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanout exchange config
 */
@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("hmall.fanout");
    }

    @Bean
    public Queue fanoutQueueA() {
        return new Queue("fanout.queueA");
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue("fanout.queueB");
    }

    @Bean
    public Binding bindingA(FanoutExchange fanoutExchange, Queue fanoutQueueA) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(FanoutExchange fanoutExchange, Queue fanoutQueueB) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}

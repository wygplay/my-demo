package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleConsumeListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "simple.queue")
    public void onMessage(String message) {
        log.info("Received message: {}", message);
    }
}

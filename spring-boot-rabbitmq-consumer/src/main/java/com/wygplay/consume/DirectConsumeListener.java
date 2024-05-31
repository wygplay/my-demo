package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * queueA routingKey=blue, red
 * queueB routingKey=blue, yellow
 */
@Slf4j
@Component
public class DirectConsumeListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "direct.queueA")
    public void consumeA(String message) {
        log.info("direct consumeA consumed: {}", message);
    }

    @RabbitListener(queues = "direct.queueB")
    public void consumeB(String message) {
        log.info("direct consumeB consumed: {}", message);
    }
}

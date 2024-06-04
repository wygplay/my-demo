package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoConsumeListener {

    @RabbitListener(queues = "hmall.demo.queue")
    public void consume(String message) {
        log.info("consume consumed: {}", message);
    }
}

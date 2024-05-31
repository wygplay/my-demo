package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fanout 模型
 * 广播模式
 * exchange hmall.fanout
 * queue fanout.queueA, fanout.queueB
 */
@Slf4j
@Component
public class FanoutConsumeListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "fanout.queueA")
    public void consumeA(String message) {
        log.info("fanout consumeA consumed: {}", message);
    }

    @RabbitListener(queues = "fanout.queueB")
    public void consumeB(String message) {
        log.info("fanout consumeB consumed: {}", message);
    }
}

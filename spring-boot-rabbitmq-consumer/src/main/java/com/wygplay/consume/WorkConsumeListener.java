package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Work 模型
 * 解决默认配置下消费者消费速度不同导致的消息积压问题
 * 配置：spring.rabbitmq.listener.simple.perfetch=1
 */
@Slf4j
@Component
public class WorkConsumeListener {

        @RabbitListener(queues = "work.queue")
        public void consumeA(String message) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("consumeA consumed: {}", message);
        }

        @RabbitListener(queues = "work.queue")
        public void consumeB(String message) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("consumeB consumed: {}", message);
        }
}

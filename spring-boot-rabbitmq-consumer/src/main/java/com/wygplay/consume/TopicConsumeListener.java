package com.wygplay.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Topic 模型
 * 通配符模式 # 匹配0个或多个单词 ; * 匹配一个单词
 * queueA routingKey=china.#
 * queueB routingKey=#.news
 */
@Slf4j
@Component
public class TopicConsumeListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.queueA"), exchange = @Exchange(value = "hmall.topic", type = ExchangeTypes.TOPIC), key = "china.#"))
    public void consumeA(String message) {
        log.info("topic consumeA consumed: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("topic.queueB"), exchange = @Exchange(value = "hmall.topic", type = ExchangeTypes.TOPIC), key = "#.news"))
    public void consumeB(String message) {
        log.info("topic consumeB consumed: {}", message);
    }
}

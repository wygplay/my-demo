package com.wygplay;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MqProducerApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSend() {
        String queueName = "simple.queue";
        String msg = "hello simple.queue!";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    @Test
    void testSendWork() {
        String queueName = "work.queue";
        String msg = "hello work.queue! ";
        for (int i = 1; i < 101; i++) {
            rabbitTemplate.convertAndSend(queueName, msg + i);
        }
    }

    @Test
    void testSendFanout() {
        String exchangeName = "hmall.fanout";
        String msg = "hello, I'm routed by fanout!";
        rabbitTemplate.convertAndSend(exchangeName, "", msg);
    }

    @Test
    void testSendDirect() {
        String exchangeName = "hmall.direct";
        String blue = "hello, I'm blue!";
        String yellow = "hello, I'm yellow!";
        String red = "hello, I'm red!";
        rabbitTemplate.convertAndSend(exchangeName, "blue", blue);
        rabbitTemplate.convertAndSend(exchangeName, "red", red);
        rabbitTemplate.convertAndSend(exchangeName, "yellow", yellow);
    }

    @Test
    void testSendTopic() {
        String exchangeName = "hmall.topic";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", "always good news");
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", "tomorrow is a sunny day");
        rabbitTemplate.convertAndSend(exchangeName, "japan.news", "someone is disgusting");
        rabbitTemplate.convertAndSend(exchangeName, "news", "news: another piece of good news");
    }

    @Test
    void testMessageConvertor() {
        String queueName = "object.queue";
        Map<String, String> map = new HashMap<>();
        map.put("name", "guanyu");
        map.put("skill", "dragon");
        rabbitTemplate.convertAndSend(queueName, map);
    }
}
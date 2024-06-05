package com.wygplay;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;

@Slf4j
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

    @Test
    void testPublisherConfirms() {
        String exchangeName = "hmall.confirm.direct";
        String wrongExchangeName = "hmall.confirm.direct1";
        String queueName = "confirm.queue";
        String routingKey = "confirm";
        String wrongRoutingKey = "confirm1";
        String msg = "hello confirm.queue!";
        CorrelationData cd = new CorrelationData();
        cd.getFuture().addCallback(new ListenableFutureCallback<CorrelationData.Confirm>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("confirm error: {}", ex.getMessage());
            }

            @Override
            public void onSuccess(CorrelationData.Confirm result) {
                if (result.isAck()) {
                    log.info("confirm success");
                } else {
                    log.error("confirm fail reason: {}", result.getReason());
                    rabbitTemplate.convertAndSend(exchangeName, routingKey, "retry: hello confirm.queue!");
                }
            }
        });

        rabbitTemplate.convertAndSend(exchangeName, routingKey, msg, cd);
        rabbitTemplate.convertAndSend(exchangeName, wrongRoutingKey, msg, cd);
        rabbitTemplate.convertAndSend(exchangeName, wrongRoutingKey, msg, cd);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rabbitTemplate.convertAndSend(wrongExchangeName, routingKey, msg, cd);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
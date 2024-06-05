package com.wygplay.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 统一配置RabbitmqTemplate confirm return回调函数
 * 打印confirm return机制返回的的信息
 */
@Slf4j
@Component
public class ReturnCallBackConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitTemplate template = applicationContext.getBean(RabbitTemplate.class);
        template.setReturnsCallback((returnedMessage)-> {
            log.info("returnCallback message: {}, replyText: {}, exchange: {}, routingKey: {}", returnedMessage.getMessage(), returnedMessage.getReplyText(), returnedMessage.getExchange(), returnedMessage.getRoutingKey());
        });
    }
}

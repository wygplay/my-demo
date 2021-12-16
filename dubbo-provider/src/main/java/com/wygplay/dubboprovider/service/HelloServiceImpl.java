package com.wygplay.dubboprovider.service;

import com.wygplay.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/12/15 16:48
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String message) {
        return "hello " + message;
    }
}

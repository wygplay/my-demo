package cn.wygplay.dubboconsumer.controller;

import com.wygplay.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/12/15 16:49
 */
@RestController
public class HelloController {

    @DubboReference
    private HelloService helloService;

    @RequestMapping(value = "/hello")
    public String sayHello(String message) {
        return helloService.sayHello(message);
    }
}

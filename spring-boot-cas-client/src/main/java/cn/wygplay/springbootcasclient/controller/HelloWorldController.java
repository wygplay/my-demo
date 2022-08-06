package cn.wygplay.springbootcasclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wyg
 * @date 2022/7/11 下午10:19
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hi")
    public String helloWorld() {
        return "hello world";
    }
}

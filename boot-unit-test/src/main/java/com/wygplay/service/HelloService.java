package com.wygplay.service;

import com.wygplay.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyg
 * @date 2022/10/21 14:15
 */
@Service
public class HelloService {
    @Autowired
    private HelloDao helloDao;

    public String hello() {
        return helloDao.getHello();
    }
}

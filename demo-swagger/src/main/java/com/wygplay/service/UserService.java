package com.wygplay.service;

import com.wygplay.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wyg
 * @date 2022/4/26 20:23
 */
@Service
@Slf4j
public class UserService {
    public void saveUser(User user) {
        log.info("User saved");
    }
}

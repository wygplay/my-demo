package com.wygplay.mybatisplus.service;

import com.wygplay.mybatisplus.dao.UserDao;
import com.wygplay.mybatisplus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyg
 * @date 2023/2/21 15:39
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.selectById(id);
    }
}

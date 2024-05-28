package com.wygplay.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wygplay.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wyg
 * @date 2023/2/21 15:39
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

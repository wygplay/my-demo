package com.wygplay.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wyg
 * @date 2023/2/21 15:42
 */
@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    private String name;
    private String phone;
}

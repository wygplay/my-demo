package com.wygplay.controller;

import com.wygplay.entity.User;
import com.wygplay.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wyg
 * @date 2022/4/26 20:18
 */
@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ApiModelProperty(value = "查询用户信息", notes = "通过url中的id查询对应的用户信息")
    public User getUser(@ApiParam(value = "id", required = true, example = "1", type="int") @PathVariable String id) {
        return new User();
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存用户", notes = "根据提供的信息，在系统中创建用户")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "success";
    }
}

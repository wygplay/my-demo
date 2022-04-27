package com.wygplay.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyg
 * @date 2022/4/26 20:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="用户实体")
public class User {
    @ApiModelProperty(value = "用户ID", notes = "自动生成，不需要传递", hidden = true)
    private String id;
    @ApiModelProperty(value = "用户名", example = "张三", position = 1)
    private String name;
    @ApiModelProperty(value = "性别编码", notes = "0 女；1 男", example = "1", position = 2)
    private int sex;
    @ApiModelProperty(value = "年龄", example="20", position = 3)
    private int age;
}

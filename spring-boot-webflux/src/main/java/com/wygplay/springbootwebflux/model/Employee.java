package com.wygplay.springbootwebflux.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author wyg
 * @date 2023/2/11 0:54
 */
@Data
@Builder
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
}

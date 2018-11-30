package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;

    private Integer age;

    private String sex;
}

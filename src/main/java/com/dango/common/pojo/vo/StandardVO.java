package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardVO {
    private Long id;

    private String name;

    private String description;

    private Integer cost;

}
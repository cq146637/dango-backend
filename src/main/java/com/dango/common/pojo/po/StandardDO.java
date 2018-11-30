package com.dango.common.pojo.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class StandardDO {
    private Long id;

    private String name;

    private String description;

    private Long cost;

    private Date createTime;
}
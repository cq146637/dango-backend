package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RemarkVO {
    private Long id;

    private Long orderInfoId;

    private String customerRealName;

    private Long standardId;

    private String standardName;

    private String content;

    private Date createTime;
}
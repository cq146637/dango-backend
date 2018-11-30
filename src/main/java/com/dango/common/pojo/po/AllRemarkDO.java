package com.dango.common.pojo.po;

import lombok.Data;

import java.util.Date;

@Data
public class AllRemarkDO {
    private Long id;

    private Long orderInfoId;

    private String customerRealName;

    private Long standardId;

    private String standardName;

    private String content;

    private Date createTime;

}

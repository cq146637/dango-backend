package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderInfoVO {
    private Long id;

    private Long standardId;

    private String standardName;

    private Long roomId;

    private String roomLabel;

    private Long customerId;

    private String customerRealName;

    private String customerIdentityCard;

    private String customerPhone;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Date createTime;

}
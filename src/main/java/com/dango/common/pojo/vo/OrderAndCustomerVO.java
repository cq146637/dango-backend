package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderAndCustomerVO {

    private Long orderInfoId;

    private String customerRealName;

}
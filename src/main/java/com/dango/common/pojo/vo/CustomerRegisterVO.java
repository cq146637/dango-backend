package com.dango.common.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户注册界面对应的 VO
 */
@Data
public class CustomerRegisterVO {
    private String username;
    private String password;
    private String real_name;
    private String identity_card;
    private String phone;
}

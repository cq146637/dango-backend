package com.dango.common.pojo.vo;

import lombok.Data;
import java.util.*;

/**
 * 用户修改界面对应的 VO
 */
@Data
public class CustomerUpdataUserVO {
    private Long id;

    private String real_name;

    private String identity_card;

    private String phone;

    private Long balance;

}

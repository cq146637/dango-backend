package com.dango.common.pojo.dto;
import com.dango.common.util.LocalDateTimeUtil;
import lombok.Builder;
import lombok.Data;

/**
 * 前后端数据交互对象
 *
 * @author Autumn
 * @date 2018/9/6
 */
@Data
@Builder
public class Result<T> {

    /**
     * 时间戳
     */
    @Builder.Default
    private String timestamp = LocalDateTimeUtil.displayNow();

    /**
     * 成功标志
     */
    private Boolean success;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
}

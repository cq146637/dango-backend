package com.dango.common.util;

import com.dango.common.pojo.dto.Result;

/**
 * @author dango
 * @date 2018/9/6
 */
public class ResultUtil {

    public static Result success(Object data) {
        return Result.builder()
                .success(true)
                .code(200)
                .msg("OK")
                .data(data)
                .build();
    }

    public static Result failure(Integer code, String msg) {
        return Result.builder()
                .success(false)
                .code(code)
                .msg(msg)
                .build();
    }
}

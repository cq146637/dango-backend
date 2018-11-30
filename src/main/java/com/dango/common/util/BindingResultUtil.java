package com.dango.common.util;

import com.dango.common.exception.DangoException;
import org.springframework.validation.BindingResult;

/**
 * @author dango
 * @date 2018/9/12
 */
public class BindingResultUtil {
    /**
     * 字段校验 - 将第一条错误信息抛出
     *
     * @param bindingResult validation 字段校验结果
     */
    public static void validate(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String firstFieldError = bindingResult.getFieldError().getDefaultMessage();
            throw new DangoException(firstFieldError);
        }
    }
}

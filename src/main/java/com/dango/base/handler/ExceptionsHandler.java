package com.dango.base.handler;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.dto.Result;
import com.dango.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常统一处理类
 *
 * @author dango
 * @date 2018/9/6
 */
@ControllerAdvice
public class ExceptionsHandler {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    /**
     * 处理业务异常
     *
     * @param e 业务异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(DangoException.class)
    public Result handleAutumnException(DangoException e) {
        return ResultUtil.failure(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他系统异常
     *
     * @param e 系统异常
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        logger.error("系统异常 => ", e);
        return ResultUtil.failure(500, "Oops！服务器无法处理你的请求 :(");
    }
}

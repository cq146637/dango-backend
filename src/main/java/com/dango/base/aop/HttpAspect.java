package com.dango.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpAspect 用于拦截 Http 请求和响应
 *
 * @author dango
 * @date 2018/9/6
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * com.dango.core.controller.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("Request <---");
        logger.info("URL: {}", request.getRequestURL());
        logger.info("Method: {}", request.getMethod());
        logger.info("IP: {}", request.getRemoteAddr());
        logger.info("SessionID: {}", request.getSession().getId());
        logger.info("Class-Method: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Args: {}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "response", pointcut = "pointcut()")
    public void doAfterReturning(Object response) {
        logger.info("Response --->");
        logger.info("Result: {}", response);
    }

    @AfterThrowing(throwing = "exception", pointcut = "pointcut()")
    public void doAfterThrowing(Exception exception) {
        logger.info("Response --->");
        logger.info("Exception-Message: {}", exception.getMessage());
    }
}

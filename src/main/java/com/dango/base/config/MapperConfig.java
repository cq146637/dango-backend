package com.dango.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 SpringBoot 扫描 mybatis mapper 接口包
 *
 * @author dango
 * @date 2018/9/6
 */
@Configuration
@MapperScan("com.dango.core.dao")
public class MapperConfig {}

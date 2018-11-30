package com.dango.core.dao;

import com.dango.common.pojo.vo.OrderInfoVO;

import java.util.List;

public interface OrderInfoViewMapper {
    List<OrderInfoVO> selectAll();
}
package com.dango.core.dao;

import com.dango.common.pojo.po.OrderInfoDO;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfoDO record);

    int insertSelective(OrderInfoDO record);

    OrderInfoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfoDO record);

    int updateByPrimaryKey(OrderInfoDO record);

    List<OrderInfoDO> selectAll();
}
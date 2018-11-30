package com.dango.core.dao;

import com.dango.common.pojo.po.RoomDO;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoomDO record);

    int insertSelective(RoomDO record);

    RoomDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomDO record);

    int updateByPrimaryKey(RoomDO record);

    List<RoomDO> selectAll();

    List<RoomDO> selectByStandardIdAndStatus(Long id);
}
package com.dango.core.dao;

import com.dango.common.pojo.po.RoomPicDO;

public interface RoomPicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoomPicDO record);

    int insertSelective(RoomPicDO record);

    RoomPicDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomPicDO record);

    int updateByPrimaryKey(RoomPicDO record);
}
package com.dango.core.dao;

import com.dango.common.pojo.po.RemarkDO;

import java.util.List;

public interface RemarkMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RemarkDO record);

    int insertSelective(RemarkDO record);

    RemarkDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RemarkDO record);

    int updateByPrimaryKey(RemarkDO record);

    List<RemarkDO> selectAll();
}
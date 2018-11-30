package com.dango.core.dao;

import com.dango.common.pojo.po.StandardDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StandardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StandardDO record);

    int insertSelective(StandardDO record);

    StandardDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StandardDO record);

    int updateByPrimaryKey(StandardDO record);

    List<StandardDO> selectAll();

    StandardDO selectByStandName(@Param("name") String name);
}
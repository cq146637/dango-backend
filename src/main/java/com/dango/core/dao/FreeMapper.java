package com.dango.core.dao;


import com.dango.common.pojo.po.FreeDO;

import java.util.List;

public interface FreeMapper {
    List<FreeDO> selectByPrimaryKey(Long id);
}

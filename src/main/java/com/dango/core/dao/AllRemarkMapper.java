package com.dango.core.dao;

import com.dango.common.pojo.po.AllRemarkDO;

import java.util.List;


public interface AllRemarkMapper {
   List<AllRemarkDO> selectByName(String name);
}

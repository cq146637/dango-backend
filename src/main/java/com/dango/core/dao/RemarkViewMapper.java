package com.dango.core.dao;

import com.dango.common.pojo.vo.RemarkVO;

import java.util.List;

public interface RemarkViewMapper {
    List<RemarkVO> selectAll();
}
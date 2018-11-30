package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.po.StandardDO;
import com.dango.common.pojo.vo.StandardFindDecVO;
import com.dango.common.pojo.dto.Pagination;
import com.dango.core.dao.StandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardService {

    @Autowired
    private StandardMapper standardMapper;

    /**
     * 查找
     * @param standardFindDecVO
     * @return 房间类型标准信息
     */
    public StandardDO findStandard(StandardFindDecVO standardFindDecVO) {
        StandardDO standardDO = standardMapper.selectByStandName(standardFindDecVO.getName());
        String name = standardFindDecVO.getName();
        System.out.println(name);
        if (standardDO == null) {
            throw new DangoException("没有找到改房间的信息！");
        }
        return standardDO;
    }
    public Pagination showAllStandard() {
        // 获取所有的房间标准
        List<StandardDO> standardDOS = standardMapper.selectAll();
        return Pagination.build(10,1,100, standardDOS);
    }

    public StandardDO addOneStandard(StandardDO standardDO) {
        // 添加一条标准信息
        int rows = standardMapper.insert(standardDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return standardMapper.selectByPrimaryKey(standardDO.getId());
    }

    public List<Integer> deleteStandards(List<Integer> ids) {
        // 删除列表中所有标准信息
        try {
            for (Integer i: ids) {
                standardMapper.deleteByPrimaryKey(i.longValue());
            }
            return ids;
        } catch (Exception e) {
            throw new DangoException("数据库异常！");
        }
    }

    public StandardDO editStandard(StandardDO standardDO) {
        // 修改标准信息
        int rows = standardMapper.updateByPrimaryKeySelective(standardDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return standardMapper.selectByPrimaryKey(standardDO.getId());
    }

    public List<StandardDO> getRoomStandard() {
        // 获取所有的房间标准,不分页
        return standardMapper.selectAll();
    }
}

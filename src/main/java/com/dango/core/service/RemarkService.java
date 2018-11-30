package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.po.AllRemarkDO;
import com.dango.common.pojo.po.OrderInfoDO;
import com.dango.common.pojo.po.RemarkDO;
import com.dango.common.pojo.vo.AllRemarkVO;
import com.dango.common.pojo.vo.OrderAndCustomerVO;
import com.dango.common.pojo.vo.RemarkVO;
import com.dango.core.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemarkService {

    @Autowired
    private AllRemarkMapper allRemarkMapper;

    @Autowired
    private RemarkMapper remarkMapper;

    @Autowired
    private RemarkViewMapper remarkViewMapper;

    @Autowired
    private StandardMapper standardMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public Pagination<List<RemarkVO>> showAllRemark() {
        List<RemarkVO> remarkVOS = remarkViewMapper.selectAll();
        return Pagination.build(10,1,100, remarkVOS);
    }

    public List<OrderAndCustomerVO> getOrderCustomer() {
        List<OrderAndCustomerVO> orderAndCustomerVOS = new ArrayList<>();
        List<OrderInfoDO> orderInfoDOS = orderInfoMapper.selectAll();
        for (OrderInfoDO orderInfoDO: orderInfoDOS) {
            String customerRealName = customerMapper.selectByPrimaryKey(orderInfoDO.getCustomerId()).getRealName();
            orderAndCustomerVOS.add(OrderAndCustomerVO.builder()
                    .orderInfoId(orderInfoDO.getId())
                    .customerRealName(customerRealName)
                    .build());
        }
        return orderAndCustomerVOS;
    }

    public RemarkDO addOneRemark(RemarkDO remarkDO) {
        int rows = remarkMapper.insertSelective(remarkDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return remarkMapper.selectByPrimaryKey(remarkDO.getId());
    }

    public List<Long> deleteRemarks(List<Long> ids) {
        // 删除列表中所有标准信息
        try {
            for (Long i: ids) {
                remarkMapper.deleteByPrimaryKey(i);
            }
            return ids;
        } catch (Exception e) {
            throw new DangoException("数据库异常！");
        }
    }

    public RemarkDO editRemark(RemarkDO remarkDO) {
        // 修改标准信息
        int rows = remarkMapper.updateByPrimaryKeySelective(remarkDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return remarkMapper.selectByPrimaryKey(remarkDO.getId());
    }

    public List<AllRemarkDO> allRemark(AllRemarkVO allRemarkVO) {

        List<AllRemarkDO> allRemarkDO = allRemarkMapper.selectByName(allRemarkVO.getName());
        if (allRemarkDO == null) {
            throw new DangoException("没有任何评论");
        }
        return allRemarkDO;
    }
}

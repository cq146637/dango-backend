package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.po.CustomerDO;
import com.dango.common.pojo.po.OrderInfoDO;
import com.dango.common.pojo.po.RoomDO;
import com.dango.common.pojo.po.StandardDO;
import com.dango.common.pojo.vo.OrderInfoVO;
import com.dango.common.pojo.vo.StandardAndRoomVO;
import com.dango.core.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderInfoViewMapper orderInfoViewMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private StandardMapper standardMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public Pagination<List<OrderInfoVO>> showAllOrderInfo() {
        List<OrderInfoVO> orderInfoVOS = orderInfoViewMapper.selectAll();
        return Pagination.build(10,1,100, orderInfoVOS);
    }

    public List<StandardAndRoomVO> getStandardAndRoom() {
        // 添加订单时获取房间标准和房间
        List<StandardAndRoomVO> standardAndRoomVOS = new ArrayList<>();
        List<StandardDO> standardDOS = standardMapper.selectAll();
        List<RoomDO> roomDOS;
        for (StandardDO standardDO: standardDOS) {
            StandardAndRoomVO standardAndRoomVO = StandardAndRoomVO.builder()
                    .value(standardDO.getId().toString())
                    .label(standardDO.getName())
                    .build();
            roomDOS = roomMapper.selectByStandardIdAndStatus(standardDO.getId());
            List<StandardAndRoomVO> temp = new ArrayList<>();
            for (RoomDO roomDO: roomDOS) {
                temp.add(StandardAndRoomVO.builder()
                        .value(roomDO.getId().toString())
                        .label(roomDO.getLabel())
                        .build());
            }
            standardAndRoomVO.setChildren(temp);
            standardAndRoomVOS.add(standardAndRoomVO);
        }
        return standardAndRoomVOS;
    }

    public OrderInfoDO addOneOrderInfo(OrderInfoDO orderInfoDO) {
        // 添加一条订单信息
        // 首先判断该用户余额是否足够支付
        CustomerDO customerDO = customerMapper.selectByPrimaryKey(orderInfoDO.getCustomerId());
        StandardDO standardDO = standardMapper.selectByPrimaryKey(
                roomMapper.selectByPrimaryKey(orderInfoDO.getRoomId()).getStandardId()
        );
        if (standardDO.getCost() > customerDO.getBalance()) {
            throw new DangoException("用户余额不足！");
        } else {
            customerDO.setBalance(customerDO.getBalance() - standardDO.getCost());
        }
        // 更新用户账户余额
        customerMapper.updateByPrimaryKeySelective(customerDO);
        int rows = orderInfoMapper.insert(orderInfoDO);
        RoomDO roomDO = new RoomDO();
        roomDO.setId(orderInfoDO.getRoomId());
        roomDO.setStatus(1);
        roomMapper.updateByPrimaryKeySelective(roomDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return orderInfoMapper.selectByPrimaryKey(orderInfoDO.getId());
    }

    public List<Integer> deleteOrderInfos(List<Integer> ids) {
        // 删除列表中所有订单信息
        try {
            for (Integer i: ids) {
                // 下面更新房间信息
                OrderInfoDO orderInfoDO =  orderInfoMapper.selectByPrimaryKey(i.longValue());
                Long currTimeStamp = new Date().getTime();
                if (currTimeStamp > orderInfoDO.getStartTime().getTime() && currTimeStamp < orderInfoDO.getEndTime().getTime()) {
                    // 只有订单的在已入住期间删除订单才会更新
                    RoomDO roomDO = roomMapper.selectByPrimaryKey(orderInfoDO.getRoomId());
                    roomDO.setStatus(0);  // 0 为空房
                    roomMapper.updateByPrimaryKeySelective(roomDO);
                }
                // 删除订单
                orderInfoMapper.deleteByPrimaryKey(i.longValue());
            }
            return ids;
        } catch (Exception e) {
            throw new DangoException("数据库异常！");
        }
    }

    public OrderInfoDO editOneOrderInfo(OrderInfoDO orderInfoDO) {
        Long currTimeStamp = new Date().getTime();
        RoomDO roomDO = new RoomDO();
        roomDO.setId(orderInfoDO.getRoomId());
        roomDO.setStatus(0);
        if (orderInfoDO.getStartTime().getTime() > currTimeStamp) {
            orderInfoDO.setStatus(0);
            roomDO.setStatus(1);
        } else if (orderInfoDO.getEndTime().getTime() < currTimeStamp) {
            orderInfoDO.setStatus(2);
        } else {
            orderInfoDO.setStatus(1);
            roomDO.setStatus(1);
        }
        int rows = orderInfoMapper.updateByPrimaryKeySelective(orderInfoDO);
        roomMapper.updateByPrimaryKeySelective(roomDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return orderInfoMapper.selectByPrimaryKey(orderInfoDO.getId());
    }
}

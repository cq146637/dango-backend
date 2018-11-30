package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.po.FreeDO;
import com.dango.common.pojo.po.RoomDO;
import com.dango.common.pojo.vo.FreeRoomVO;
import com.dango.common.pojo.vo.RoomVO;
import com.dango.core.dao.FreeMapper;
import com.dango.core.dao.RoomMapper;
import com.dango.core.dao.StandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private FreeMapper freeMapper;

    @Autowired
    private StandardMapper standardMapper;

    public Pagination<List<RoomVO>> showAllRoom() {
        List<RoomVO> roomVOS = new ArrayList<>();
        List<RoomDO> roomDOS = roomMapper.selectAll();
        for (RoomDO roomDO: roomDOS) {
            roomVOS.add(RoomVO.builder()
                    .id(roomDO.getId())
                    .label(roomDO.getLabel())
                    .peopleCount(roomDO.getPeopleCount())
                    .standardId(roomDO.getStandardId())
                    .standardName(standardMapper.selectByPrimaryKey(roomDO.getStandardId()).getName())
                    .status(roomDO.getStatus())
                    .build());
        }
        return Pagination.build(10,1,100, roomVOS);
    }

    public RoomDO addOneRoom(RoomDO roomDO) {
        int rows = roomMapper.insertSelective(roomDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return roomMapper.selectByPrimaryKey(roomDO.getId());
    }

    public List<Integer> deleteRooms(List<Integer> ids) {
        // 删除列表中所有房间信息
        try {
            for (Integer id: ids) {
                roomMapper.deleteByPrimaryKey(id.longValue());
            }
            return ids;
        } catch (RuntimeException e) {
            throw new DangoException("数据库异常！");
        }
    }

    public RoomDO editOneRoom(RoomDO roomDO) {
        // 修改标准信息
        int rows = roomMapper.updateByPrimaryKeySelective(roomDO);
        if ( rows != 1) {
            throw new DangoException("数据库异常！");
        }
        return roomMapper.selectByPrimaryKey(roomDO.getId());
    }

    //查询空房间
    public List<FreeDO> freeRoom(FreeRoomVO freeRoomVO) {
        List<FreeDO> freeDOS =freeMapper.selectByPrimaryKey(freeRoomVO.getStandard_id());
        if (freeDOS == null) {
            throw new DangoException("没有空余房间！");
        }
        return freeDOS;
    }
}

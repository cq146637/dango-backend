package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.po.FreeDO;
import com.dango.common.pojo.po.RoomDO;
import com.dango.common.pojo.vo.FreeRoomVO;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.RoomService;
import com.dango.core.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private StandardService standardService;

    @GetMapping("show_room")
    public Result showAllRoom() {
        Pagination pagination = roomService.showAllRoom();
        return ResultUtil.success(pagination);
    }

    @PostMapping("get_room_standard")
    public Result getRoomStandard() {
        return ResultUtil.success(standardService.getRoomStandard());
    }

    @PostMapping("add_room")
    public Result addOneRoom(@RequestBody RoomDO roomDO) {
        roomDO = roomService.addOneRoom(roomDO);
        return ResultUtil.success(roomDO);
    }

    @PostMapping("delete_rooms")
    public Result deleteRooms(@RequestBody List<Integer> ids) {
        ids = roomService.deleteRooms(ids);
        return ResultUtil.success(ids);
    }

    @PostMapping("edit_room")
    public Result editOneRoom(@RequestBody RoomDO roomDO) {
        roomService.editOneRoom(roomDO);
        return ResultUtil.success(roomDO);
    }

    @PostMapping("freeRoom")
    public Result freeRoom(@RequestBody FreeRoomVO freeRoomVO){
        List<FreeDO> freeDO=roomService.freeRoom(freeRoomVO);
        return ResultUtil.success(freeDO);
    }
}

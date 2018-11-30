package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.po.OrderInfoDO;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderInfoController {

    @Autowired
    private OrderInfoService  orderInfoService;

    @GetMapping("show_order_info")
    public Result showAllOrderInfo() {
        Pagination pagination = orderInfoService.showAllOrderInfo();
        return ResultUtil.success(pagination);
    }

    @PostMapping("get_order_standard_and_room")
    public Result getStandardAndRoom() {
        return ResultUtil.success(orderInfoService.getStandardAndRoom());
    }

    @PostMapping("add_order")
    public Result addOneOrderInfo(@RequestBody OrderInfoDO orderInfoDO) {
        return ResultUtil.success(orderInfoService.addOneOrderInfo(orderInfoDO));
    }

    @PostMapping("delete_order")
    public Result deleteOrderInfos(@RequestBody List<Integer> ids) {
        // 删除订单信息
        ids = orderInfoService.deleteOrderInfos(ids);
        return ResultUtil.success(ids);
    }

    @PostMapping("edit_order_info")
    public Result editOneOrderInfo(@RequestBody OrderInfoDO orderInfoDO) {
        // 删除订单信息
        orderInfoDO = orderInfoService.editOneOrderInfo(orderInfoDO);
        return ResultUtil.success(orderInfoDO);
    }
}

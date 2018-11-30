package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.po.RemarkDO;
import com.dango.common.pojo.vo.OrderAndCustomerVO;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dango.common.pojo.po.AllRemarkDO;
import com.dango.common.pojo.vo.AllRemarkVO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/")
public class RemarkController {

    @Autowired
    private RemarkService  remarkService;

    @GetMapping("show_remark")
    public Result showAllRemark() {
        Pagination pagination = remarkService.showAllRemark();
        return ResultUtil.success(pagination);
    }

    @GetMapping("get_order_customer")
    public Result getOrderCustomer() {
        List<OrderAndCustomerVO> orderAndCustomerVOS= remarkService.getOrderCustomer();
        return ResultUtil.success(orderAndCustomerVOS);
    }

    @PostMapping("add_remark")
    public Result addOneRemark(@RequestBody RemarkDO remarkDO) {
        remarkDO = remarkService.addOneRemark(remarkDO);
        return ResultUtil.success(remarkDO);
    }

    @PostMapping("delete_remark")
    public Result deleteRemarks(@RequestBody List<Long> ids) {
        // 删除标准信息
        ids = remarkService.deleteRemarks(ids);
        return ResultUtil.success(ids);
    }

    @PostMapping("edit_remark")
    public Result editRemark(@RequestBody RemarkDO remarkDO) {
        // 修改标准信息
        remarkDO = remarkService.editRemark(remarkDO);
        return ResultUtil.success(remarkDO);
    }

    @PostMapping("allRemark")
    public Result allRemark (@RequestBody AllRemarkVO allRemarkVO){
        List<AllRemarkDO> allRemarkDO = remarkService.allRemark(allRemarkVO);
        return ResultUtil.success(allRemarkDO);
    }

}

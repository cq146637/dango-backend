package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.po.StandardDO;
import com.dango.common.pojo.vo.StandardFindDecVO;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("show_standard")
    public Result showAllStandard() {
        Pagination pagination = standardService.showAllStandard();
        return ResultUtil.success(pagination);
    }

    @PostMapping("add_standard")
    public Result addOneStandard(@RequestBody StandardDO standardDO) {
        // 添加一条标准信息
        standardDO = standardService.addOneStandard(standardDO);
        return ResultUtil.success(standardDO);

    }

    @PostMapping("delete_standard")
    public Result deleteStandards(@RequestBody List<Integer> ids) {
        // 删除标准信息
        ids = standardService.deleteStandards(ids);
        return ResultUtil.success(ids);
    }

    @PostMapping("edit_standard")
    public Result editStandard(@RequestBody StandardDO standardDO) {
        // 修改标准信息
        standardDO = standardService.editStandard(standardDO);
        return ResultUtil.success(standardDO);
    }
    /**
     *查询房间的标准
     */
    @PostMapping(value="findStandard")
    public Result findStandard(@RequestBody StandardFindDecVO standardFindDecVO){
        StandardDO standardDO = standardService.findStandard(standardFindDecVO);
        return ResultUtil.success(standardDO);
    }

}

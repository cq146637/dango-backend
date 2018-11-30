package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;
import com.dango.common.pojo.po.AdministratorDO;
import com.dango.common.pojo.vo.AdministratorLoginVO;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("alogin")
    public Result login(@RequestBody AdministratorLoginVO administratorLogin) {
        AdministratorDO administratorDO = administratorService.login(administratorLogin);
        return ResultUtil.success(administratorDO);
    }

    @GetMapping("show_adminstrator")
    public Result showAllAdministrator() {
        Pagination pagination = administratorService.showAllAdministrator();
        return ResultUtil.success(pagination);
    }
}

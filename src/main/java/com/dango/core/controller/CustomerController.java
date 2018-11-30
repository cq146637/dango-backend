package com.dango.core.controller;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.dto.Result;

import com.dango.common.pojo.po.CustomerDO;
import com.dango.common.pojo.vo.*;
import com.dango.common.util.ResultUtil;
import com.dango.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("show_customer")
    public Result showAllCustomer() {
        Pagination pagination = customerService.showAllCustomer();
        return ResultUtil.success(pagination);
    }

    @PostMapping("register")
    public Result register(@RequestBody CustomerRegisterVO customerRegisterVO){
        CustomerDO customerDO=customerService.register(customerRegisterVO);
        return ResultUtil.success(customerDO);
    }

    @PostMapping("login")
    public Result login(@RequestBody CustomerLoginVO customerLoginVO) {
        CustomerDO customerDO = customerService.login(customerLoginVO);
        return ResultUtil.success(customerDO);
    }

    @PostMapping("findUser")
    public Result findUser(@RequestBody CustomerFindUserVO customerFindUserVO){
        CustomerDO customerDO = customerService.findUser(customerFindUserVO);
        return ResultUtil.success(customerDO);
    }

    @PostMapping("updataUser")
    public  Result updataUser(@RequestBody CustomerUpdataUserVO customerUpdataUserVO){
        CustomerDO customerDO = customerService.UpdataUser(customerUpdataUserVO);
        return ResultUtil.success(customerDO);
    }

    @PostMapping("balance")
    public  Result balance(@RequestBody CustomerBalanceVO customerBalanceVO){
        CustomerDO customerDO = customerService.balance(customerBalanceVO);
        return ResultUtil.success(customerDO);
    }

}

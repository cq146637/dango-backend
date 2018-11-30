package com.dango.core.service;

import com.dango.common.exception.DangoException;
import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.po.CustomerDO;
import com.dango.common.pojo.vo.*;
import com.dango.core.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public Pagination<List<CustomerDO>> showAllCustomer() {
        List<CustomerDO> customerDOS = customerMapper.selectAll();
        return Pagination.build(10, 1, 100, customerDOS);
    }

    /**
     * 用户注册
     *
     * @param customerRegisterVO
     * @return 注册信息
     */
    public CustomerDO register(CustomerRegisterVO customerRegisterVO) {
        CustomerDO customerDO1 = customerMapper.getByUsername(customerRegisterVO.getUsername());
        CustomerDO record = new CustomerDO();
        record.setUsername(customerRegisterVO.getUsername());
        record.setPassword(customerRegisterVO.getPassword());
        record.setRealName(customerRegisterVO.getReal_name());
        record.setIdentityCard(customerRegisterVO.getIdentity_card());
        record.setPhone(customerRegisterVO.getPhone());
        if(customerDO1==null){
            int flag = customerMapper.insertSelective(record);
            if (flag==0||flag<0) {

                throw new DangoException("用户注册失败");
            }else {
                CustomerDO customerDO = customerMapper.getByUsernameAndPassword(customerRegisterVO.getUsername(), customerRegisterVO.getPassword());
                return customerDO;
            }
        }
        throw new DangoException("用户名重复");

    }
    /**
     * 用户登录
     *
     * @param customerLoginVOLogin
     * @return 用户信息
     */
    public CustomerDO login(CustomerLoginVO customerLoginVOLogin) {

        CustomerDO customerDO = customerMapper.getByUsernameAndPassword(customerLoginVOLogin.getUsername(), customerLoginVOLogin.getPassword());
        if (customerDO == null) {
            throw new DangoException("用户名或密码错误！");
        }
        return customerDO;
    }

    //访问用户的所有信息
    public CustomerDO findUser(CustomerFindUserVO customerFindUserVO){
        CustomerDO customerDO = customerMapper.selectByPrimaryKey(customerFindUserVO.getId());
        if (customerDO == null) {
            throw new DangoException("没有找到相关用户信息！");
        }
        return customerDO;
    }
    //修改用户信息
    public CustomerDO UpdataUser(CustomerUpdataUserVO customerUpdataUserVO){
        CustomerDO record = new CustomerDO();
        record.setId(customerUpdataUserVO.getId());
        record.setRealName(customerUpdataUserVO.getReal_name());
        record.setIdentityCard(customerUpdataUserVO.getIdentity_card());
        record.setPhone(customerUpdataUserVO.getPhone());
        int flag = customerMapper.updateByPrimaryKeySelective(record);
        if (flag == 0||flag<0) {
            throw new DangoException("没有找到相关用户信息！");
        }else {
            CustomerDO customerDO = customerMapper.selectByPrimaryKey(customerUpdataUserVO.getId());

            return customerDO;
        }
    }

    //用户充值
    public CustomerDO balance(CustomerBalanceVO customerBalanceVO) {
        CustomerDO record = new CustomerDO();
        record.setId(customerBalanceVO.getId());
        record.setBalance(customerBalanceVO.getBalance());
        int flag = customerMapper.updateByPrimaryKeySelective(record);
        if (flag==0||flag<0) {
            throw new DangoException("用户充值失败");
        }else {
            CustomerDO customerDO = customerMapper.selectByPrimaryKey(customerBalanceVO.getId());
            return customerDO;
        }
    }
}

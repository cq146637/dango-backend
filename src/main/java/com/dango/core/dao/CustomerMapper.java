package com.dango.core.dao;

import com.dango.common.pojo.po.CustomerDO;
import com.dango.common.pojo.vo.CustomerUpdataUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Long id);

    //注册用户
    int insert(CustomerDO record);

    int insertCustomer(@Param("username") String username, @Param("password") String password,@Param("real_name") String real_name,@Param("identity_card") String identity_card,@Param("phone") String phone);

    int insertSelective(CustomerDO record);

    CustomerDO selectByPrimaryKey(Long id);

    //判断用户是否存在
    CustomerDO getByUsername(@Param("username") String username);

    int updateByPrimaryKeySelective(CustomerDO record);

    //修改个人信息
    int updateByPrimaryKey(CustomerDO record);

    int  updateCustomer(@Param("real_name")String real_name,@Param("identity_card") String identity_card,@Param("phone") String phone,@Param("id") Long id);

    //用户登录
    CustomerDO getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    //充值
    int  insertBalance(@Param("id")Long id, @Param("balance")String balance);

    List<CustomerDO> selectAll();
}
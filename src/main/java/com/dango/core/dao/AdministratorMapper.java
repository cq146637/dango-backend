package com.dango.core.dao;

import com.dango.common.pojo.po.AdministratorDO;
import com.dango.common.pojo.po.CustomerDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdministratorDO record);

    int insertSelective(AdministratorDO record);

    AdministratorDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdministratorDO record);

    int updateByPrimaryKey(AdministratorDO record);

    /**
     * 通过用户名和密码获取 admin 信息
     *
     * @param username
     * @param password
     * @return
     */
    AdministratorDO getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


    List<AdministratorDO> selectAll();
}
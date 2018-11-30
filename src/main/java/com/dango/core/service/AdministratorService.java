package com.dango.core.service;

import com.dango.common.pojo.dto.Pagination;
import com.dango.common.pojo.po.AdministratorDO;
import com.dango.common.exception.DangoException;
import com.dango.common.pojo.po.AdministratorDO;
import com.dango.common.pojo.vo.AdministratorLoginVO;
import com.dango.core.dao.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    public Pagination<List<AdministratorDO>> showAllAdministrator() {
        List<AdministratorDO> administratorDOS = administratorMapper.selectAll();
        return Pagination.build(10, 1, 100, administratorDOS);
    }
    /**
     * 管理员登录
     * @param administratorLogin
     * @return 管理员信息
     */
    public AdministratorDO login(AdministratorLoginVO administratorLogin) {
       AdministratorDO administratorDO = administratorMapper.getByUsernameAndPassword(administratorLogin.getUsername(), administratorLogin.getPassword());
       if (administratorDO == null) {
           throw new DangoException("用户名或密码错误！");
       }
       return administratorDO;
    }
}

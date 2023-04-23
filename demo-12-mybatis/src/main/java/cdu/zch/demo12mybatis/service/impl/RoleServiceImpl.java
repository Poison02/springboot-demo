package cdu.zch.demo12mybatis.service.impl;

import cdu.zch.demo12mybatis.entity.Role;
import cdu.zch.demo12mybatis.entity.query.RoleQueryBean;
import cdu.zch.demo12mybatis.mapper.RoleMapper;
import cdu.zch.demo12mybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zch
 **/
@Service
public class RoleServiceImpl implements RoleService {
    /**
     * roleMapper
     */
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findList(RoleQueryBean roleQueryBean) {
        return roleMapper.findList(roleQueryBean);
    }
}

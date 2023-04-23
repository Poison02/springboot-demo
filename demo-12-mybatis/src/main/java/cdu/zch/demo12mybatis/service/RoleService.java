package cdu.zch.demo12mybatis.service;

import cdu.zch.demo12mybatis.entity.Role;
import cdu.zch.demo12mybatis.entity.query.RoleQueryBean;

import java.util.List;

/**
 * @author Zch
 **/
public interface RoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}

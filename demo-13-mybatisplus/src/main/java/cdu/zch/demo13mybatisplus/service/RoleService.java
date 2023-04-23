package cdu.zch.demo13mybatisplus.service;

import cdu.zch.demo13mybatisplus.entity.Role;
import cdu.zch.demo13mybatisplus.entity.query.RoleQueryBean;

import java.util.List;

/**
 * @author Zch
 **/
public interface RoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}

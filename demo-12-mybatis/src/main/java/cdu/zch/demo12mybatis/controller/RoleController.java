package cdu.zch.demo12mybatis.controller;

import cdu.zch.demo12mybatis.entity.Role;
import cdu.zch.demo12mybatis.entity.query.RoleQueryBean;
import cdu.zch.demo12mybatis.entity.response.ResponseResult;
import cdu.zch.demo12mybatis.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zch
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @return user list
     */
    @GetMapping("list")
    public ResponseResult<List<Role>> list(RoleQueryBean roleQueryBean) {
        return ResponseResult.success(roleService.findList(roleQueryBean));
    }
}

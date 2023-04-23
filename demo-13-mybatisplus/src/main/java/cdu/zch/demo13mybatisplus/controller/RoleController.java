package cdu.zch.demo13mybatisplus.controller;

import cdu.zch.demo13mybatisplus.entity.Role;
import cdu.zch.demo13mybatisplus.entity.query.RoleQueryBean;
import cdu.zch.demo13mybatisplus.entity.response.ResponseResult;
import cdu.zch.demo13mybatisplus.service.RoleService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Query Role List")
    @GetMapping("list")
    public ResponseResult<List<Role>> list(RoleQueryBean roleQueryBean) {
        return ResponseResult.success(roleService.findList(roleQueryBean));
    }
}

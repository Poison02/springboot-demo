package cdu.zch.demo13mybatisplus.controller;

import cdu.zch.demo13mybatisplus.entity.User;
import cdu.zch.demo13mybatisplus.entity.query.UserQueryBean;
import cdu.zch.demo13mybatisplus.entity.response.ResponseResult;
import cdu.zch.demo13mybatisplus.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zch
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param user user param
     * @return user
     */
    @ApiOperation("Add/Edit User")
    @PostMapping("/add")
    public ResponseResult<User> add(User user) {
        if (user.getId()==null) {
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userService.save(user);
        } else {
            user.setUpdateTime(LocalDateTime.now());
            userService.update(user);
        }
        return ResponseResult.success(userService.findById(user.getId()));
    }


    /**
     * @return user list
     */
    @ApiOperation("Query User One")
    @GetMapping("/edit/{userId}")
    public ResponseResult<User> edit(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.findById(userId));
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("/list")
    public ResponseResult<List<User>> list(UserQueryBean userQueryBean) {
        return ResponseResult.success(userService.findList(userQueryBean));
    }
}

package cdu.zch.rbac.security.controller;

import cn.hutool.core.collection.CollUtil;
import cdu.zch.rbac.security.common.ApiResponse;
import cdu.zch.rbac.security.common.PageResult;
import cdu.zch.rbac.security.common.Status;
import cdu.zch.rbac.security.playload.PageCondition;
import cdu.zch.rbac.security.service.MonitorService;
import cdu.zch.rbac.security.utils.PageUtil;
import cdu.zch.rbac.security.utils.SecurityUtil;
import cdu.zch.rbac.security.vo.OnlineUser;
import cdu.zch.rbac.security.exception.SecurityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 监控 Controller，在线用户，手动踢出用户等功能
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-11 20:55
 */
@Slf4j
@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorService;

    /**
     * 在线用户列表
     *
     * @param pageCondition 分页参数
     */
    @GetMapping("/online/user")
    public ApiResponse onlineUser(PageCondition pageCondition) {
        PageUtil.checkPageCondition(pageCondition, PageCondition.class);
        PageResult<OnlineUser> pageResult = monitorService.onlineUser(pageCondition);
        return ApiResponse.ofSuccess(pageResult);
    }

    /**
     * 批量踢出在线用户
     *
     * @param names 用户名列表
     */
    @DeleteMapping("/online/user/kickout")
    public ApiResponse kickoutOnlineUser(@RequestBody List<String> names) {
        if (CollUtil.isEmpty(names)) {
            throw new SecurityException(Status.PARAM_NOT_NULL);
        }
        if (names.contains(SecurityUtil.getCurrentUsername())) {
            throw new SecurityException(Status.KICKOUT_SELF);
        }
        monitorService.kickout(names);
        return ApiResponse.ofSuccess();
    }
}

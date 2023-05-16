package cdu.zch.demo18swagger.service;

import cdu.zch.demo18swagger.entity.User;
import cdu.zch.demo18swagger.utils.CommonResult;

import java.util.List;

/**
 * @author Zch
 * @data 2023/5/16
 **/
public interface UserService {

    /**
     * 保存用户
     *
     * @param user 用户参数
     * @return CommonResult<User>
     */
    CommonResult<User> saveUser(User user);

    /**
     * 查询所有用户
     *
     * @return CommonResult<List<User>>
     */
    CommonResult<List<User>> findUserAll();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return CommonResult<User>
     */
    CommonResult<User> findUserById(Long id);

    /**
     * 根据id更新用户
     *
     * @param user 用户参数
     * @return CommonResult<User>
     */
    CommonResult<User> updateUserById(User user);

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return CommonResult<User>
     */
    CommonResult<User> deleteUserById(Long id);

    /**
     * 删除所有用户
     *
     * @return CommonResult<List<User>>
     */
    CommonResult<List<User>> deleteUserAll();

}

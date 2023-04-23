package cdu.zch.demo12mybatis.service;

import cdu.zch.demo12mybatis.entity.User;
import cdu.zch.demo12mybatis.entity.query.UserQueryBean;

import java.util.List;

/**
 * @author Zch
 **/
public interface UserService {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);

}

package cdu.zch.demo13mybatisplus.service.impl;

import cdu.zch.demo13mybatisplus.entity.User;
import cdu.zch.demo13mybatisplus.entity.query.UserQueryBean;
import cdu.zch.demo13mybatisplus.mapper.UserMapper;
import cdu.zch.demo13mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zch
 **/
@Service
public class UserServiceImpl implements UserService {
    /**
     * userDao.
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findList(UserQueryBean userQueryBean) {
        return userMapper.findList(userQueryBean);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(Long[] ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }
}

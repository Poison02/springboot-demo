package cdu.zch.demo12mybatis.mapper;

import cdu.zch.demo12mybatis.entity.User;
import cdu.zch.demo12mybatis.entity.query.UserQueryBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zch
 **/
@Repository
@Mapper
public interface UserMapper {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);

}

package cdu.zch.demo12mybatis.mapper;

import cdu.zch.demo12mybatis.entity.Role;
import cdu.zch.demo12mybatis.entity.query.RoleQueryBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zch
 **/
@Repository
@Mapper
public interface RoleMapper {

    List<Role> findList(RoleQueryBean roleQueryBean);

}

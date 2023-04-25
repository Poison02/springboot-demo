package cdu.zch.demo15jpa.mapper;

import cdu.zch.demo15jpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@Repository
public interface DepartmentMapper extends JpaRepository<Department, Long> {

    /**
     * 根据层级查询部门
     *
     * @param level 层级
     * @return 部门列表
     */
    List<Department> findDepartmentsByLevels(Integer level);

}

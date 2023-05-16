package cdu.zch.demo15jpa.mapper;

import cdu.zch.demo15jpa.Demo15JpaApplicationTests;
import cdu.zch.demo15jpa.entity.User;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@Slf4j
public class DepartmentMapperTest extends Demo15JpaApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试保存 ,根节点
     */
    @Test
    @Transactional
    public void testSave() {
        Collection<Department> departmentList = departmentMapper.findDepartmentsByLevels(0);

        if (departmentList.size() == 0) {
            Department testSave1 = Department.builder().name("testSave1").orderNo(0).levels(0).superior(null).build();
            Department testSave1_1 = Department.builder().name("testSave1_1").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_2 = Department.builder().name("testSave1_2").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_1_1 = Department.builder().name("testSave1_1_1").orderNo(0).levels(2).superior(testSave1_1).build();
            departmentList.add(testSave1);
            departmentList.add(testSave1_1);
            departmentList.add(testSave1_2);
            departmentList.add(testSave1_1_1);
            departmentMapper.saveAll(departmentList);

            Collection<Department> deptall = departmentMapper.findAll();
            log.debug("【部门】= {}", JSONArray.toJSONString((List) deptall));
        }


        userMapper.findById(1L).ifPresent(user -> {
            user.setName("添加部门");
            Department dept = departmentMapper.findById(2L).get();
            user.setDepartmentList(departmentList);
            userMapper.save(user);
        });

        log.debug("用户部门={}", JSONUtil.toJsonStr(userMapper.findById(1L).get().getDepartmentList()));


        departmentMapper.findById(2L).ifPresent(dept -> {
            Collection<User> userlist = dept.getUserList();
            //关联关系由user维护中间表，department userlist不会发生变化，可以增加查询方法来处理  重写getUserList方法
            log.debug("部门下用户={}", JSONUtil.toJsonStr(userlist));
        });


        userMapper.findById(1L).ifPresent(user -> {
            user.setName("清空部门");
            user.setDepartmentList(null);
            userMapper.save(user);
        });
        log.debug("用户部门={}", userMapper.findById(1L).get().getDepartmentList());

    }

}

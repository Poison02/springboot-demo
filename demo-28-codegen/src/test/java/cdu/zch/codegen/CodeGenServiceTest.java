package cdu.zch.codegen;

import cdu.zch.codegen.common.PageResult;
import cdu.zch.codegen.entity.TableRequest;
import cdu.zch.codegen.service.CodeGenService;
import cn.hutool.db.Entity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * @author Zch
 * @date 2023/7/31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CodeGenServiceTest {

    @Autowired
    private CodeGenService codeGenService;

    @Test
    public void testCodeGen() throws SQLException {
        TableRequest request = new TableRequest();
        request.setCurrentPage(1);
        request.setPageSize(10);
        request.setPrepend("jdbc:mysql://");
        request.setUrl("127.0.0.1:3306/spring-boot-demo?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        request.setUsername("root");
        request.setPassword("248613");
        request.setTableName("sec_");
        PageResult<Entity> pageResult = codeGenService.listTables(request);
        System.out.println(pageResult);
    }

}

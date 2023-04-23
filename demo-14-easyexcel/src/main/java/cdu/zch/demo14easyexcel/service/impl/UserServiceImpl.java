package cdu.zch.demo14easyexcel.service.impl;

import cdu.zch.demo14easyexcel.entity.User;
import cdu.zch.demo14easyexcel.service.UserService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Zch
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private List<User> cachedDataList = new ArrayList<>();

    @Override
    public void upload(InputStream inputStream) throws IOException {
        EasyExcelFactory.read(inputStream, User.class, new ReadListener<User>() {

            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                cachedDataList.add(user);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                cachedDataList.forEach(user -> log.info(user.toString()));
            }
        }).sheet().doRead();
    }

    @Override
    public void downloadExcel(ServletOutputStream outputStream) {
        EasyExcelFactory.write(outputStream, User.class).sheet("User").doWrite(this::getUserList);
    }

    // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
    // {} 代表普通变量 {.} 代表是list的变量 {前缀.} 前缀可以区分不同的list
    @Override
    public void fillExcelTemplate(ServletOutputStream outputStream) {

        // 确保文件可访问，这个例子的excel模板，放在根目录下面
        String templateFileName = "D:\\笔记\\spring-boot-demo\\spring-boot-demo\\demo-14-easyexcel\\test.xlsx";

        // 方案1
        try (ExcelWriter excelWriter = EasyExcelFactory.write(outputStream).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcelFactory.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
            // 如果有多个list 模板上必须有{前缀.} 这里的前缀就是 userList，然后多个list必须用 FillWrapper包裹
            excelWriter.fill(new FillWrapper("userList", getUserList()), fillConfig, writeSheet);
            excelWriter.fill(new FillWrapper("userList", getUserList()), fillConfig, writeSheet);

            excelWriter.fill(new FillWrapper("userList2", getUserList()), writeSheet);
            excelWriter.fill(new FillWrapper("userList2", getUserList()), writeSheet);

            Map<String, Object> map = new HashMap<>();
            map.put("user", "pdai");
            map.put("date", new Date());

            excelWriter.fill(map, writeSheet);
        }
    }

    private List<User> getUserList() {
        return Collections.singletonList(User.builder()
                .id(1L).userName("Poison02").email("2069820192@qq.com").phoneNumber(121231231231L)
                .description("hello world")
                .build());
    }

}
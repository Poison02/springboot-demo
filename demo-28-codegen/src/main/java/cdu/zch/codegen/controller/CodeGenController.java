package cdu.zch.codegen.controller;

import cdu.zch.codegen.common.R;
import cdu.zch.codegen.entity.GenConfig;
import cdu.zch.codegen.entity.TableRequest;
import cdu.zch.codegen.service.CodeGenService;
import cn.hutool.core.io.IoUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Zch
 * @date 2023/7/31
 **/
@RestController
// @AllArgsConstructor
@RequestMapping("/generator")
public class CodeGenController {
    private final CodeGenService codeGenService;

    public CodeGenController(CodeGenService codeGenService) {
        this.codeGenService = codeGenService;
    }

    /**
     * 列表
     *
     * @param request 参数集
     * @return 数据库表
     */
    @GetMapping("/table")
    public R listTables(TableRequest request) throws SQLException {
        return R.success(codeGenService.listTables(request));
    }

    /**
     * 生成代码
     */
    @PostMapping("")
    public void generatorCode(@RequestBody GenConfig genConfig, HttpServletResponse response) throws SQLException, IOException {
        byte[] data = codeGenService.generatorCode(genConfig);

        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
    }
}

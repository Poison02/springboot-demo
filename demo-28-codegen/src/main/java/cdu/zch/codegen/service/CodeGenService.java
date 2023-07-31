package cdu.zch.codegen.service;

import cdu.zch.codegen.common.PageResult;
import cdu.zch.codegen.entity.GenConfig;
import cdu.zch.codegen.entity.TableRequest;
import cn.hutool.db.Entity;

import java.sql.SQLException;

/**
 * @author Zch
 * @date 2023/7/31
 **/
public interface CodeGenService {
    /**
     * 生成代码
     *
     * @param genConfig 生成配置
     * @return 代码压缩文件
     */
    byte[] generatorCode(GenConfig genConfig) throws SQLException;

    /**
     * 分页查询表信息
     *
     * @param request 请求参数
     * @return 表名分页信息
     */
    PageResult<Entity> listTables(TableRequest request) throws SQLException;
}

package cdu.zch.codegen.entity;

import lombok.Data;

/**
 * <p>
 * 生成配置
 * </p>
 *
 * @author Zch
 * @date 2023/7/31
 */
@Data
public class GenConfig {
    /**
     * 请求参数
     */
    private TableRequest request;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 作者
     */
    private String author;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 表前缀
     */
    private String tablePrefix;
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 表备注
     */
    private String comments;

    public TableRequest getRequest() {
        return request;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getAuthor() {
        return author;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public String getTableName() {
        return tableName;
    }

    public String getComments() {
        return comments;
    }
}

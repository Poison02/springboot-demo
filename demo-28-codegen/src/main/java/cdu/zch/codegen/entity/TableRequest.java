package cdu.zch.codegen.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 表格请求参数
 * </p>
 *
 * @author Zch
 * @date 2023/7/31
 */
@Data
@Getter
public class TableRequest {
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * jdbc-前缀
     */
    private String prepend;
    /**
     * jdbc-url
     */
    private String url;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 表名
     */
    private String tableName;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPrepend() {
        return prepend;
    }

    public void setPrepend(String prepend) {
        this.prepend = prepend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

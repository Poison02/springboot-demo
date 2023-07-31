package cdu.zch.codegen.entity;

import lombok.Data;

import java.util.List;

/**
 * <p>
 * 表属性： https://blog.csdn.net/lkforce/article/details/79557482
 * </p>
 *
 * @author Zch
 * @date 2023/7/31
 */
@Data
public class TableEntity {
    /**
     * 名称
     */
    private String tableName;
    /**
     * 备注
     */
    private String comments;
    /**
     * 主键
     */
    private ColumnEntity pk;
    /**
     * 列名
     */
    private List<ColumnEntity> columns;
    /**
     * 驼峰类型
     */
    private String caseClassName;
    /**
     * 普通类型
     */
    private String lowerClassName;

    public String getTableName() {
        return tableName;
    }

    public String getComments() {
        return comments;
    }

    public ColumnEntity getPk() {
        return pk;
    }

    public List<ColumnEntity> getColumns() {
        return columns;
    }

    public String getCaseClassName() {
        return caseClassName;
    }

    public String getLowerClassName() {
        return lowerClassName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setPk(ColumnEntity pk) {
        this.pk = pk;
    }

    public void setColumns(List<ColumnEntity> columns) {
        this.columns = columns;
    }

    public void setCaseClassName(String caseClassName) {
        this.caseClassName = caseClassName;
    }

    public void setLowerClassName(String lowerClassName) {
        this.lowerClassName = lowerClassName;
    }
}

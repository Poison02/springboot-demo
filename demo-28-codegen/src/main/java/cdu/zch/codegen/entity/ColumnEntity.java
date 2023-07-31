package cdu.zch.codegen.entity;

import lombok.Data;

/**
 * <p>
 * 列属性： https://blog.csdn.net/lkforce/article/details/79557482
 * </p>
 *
 * @author Zch
 * @date 2023/7/31
 */
@Data
public class ColumnEntity {
    /**
     * 列表
     */
    private String columnName;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 备注
     */
    private String comments;
    /**
     * 驼峰属性
     */
    private String caseAttrName;
    /**
     * 普通属性
     */
    private String lowerAttrName;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * jdbc类型
     */
    private String jdbcType;
    /**
     * 其他信息
     */
    private String extra;

    public String getColumnName() {
        return columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getComments() {
        return comments;
    }

    public String getCaseAttrName() {
        return caseAttrName;
    }

    public String getLowerAttrName() {
        return lowerAttrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getExtra() {
        return extra;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCaseAttrName(String caseAttrName) {
        this.caseAttrName = caseAttrName;
    }

    public void setLowerAttrName(String lowerAttrName) {
        this.lowerAttrName = lowerAttrName;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}

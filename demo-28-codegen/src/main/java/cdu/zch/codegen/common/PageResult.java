package cdu.zch.codegen.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Zch
 * @date 2023/7/31
 **/
@Data
// @AllArgsConstructor
public class PageResult<T> {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private int pageNumber;

    /**
     * 每页结果数
     */
    private int pageSize;

    /**
     * 结果集
     */
    private List<T> list;

    public PageResult(Long total, int pageNumber, int pageSize, List<T> list) {
        this.total = total;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.list = list;
    }
}

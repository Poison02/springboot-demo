package cdu.zch.codegen.common;

/**
 * @author Zch
 * @date 2023/7/31
 **/
public interface IResultCode {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 获取返回消息
     *
     * @return 返回消息
     */
    String getMessage();
}

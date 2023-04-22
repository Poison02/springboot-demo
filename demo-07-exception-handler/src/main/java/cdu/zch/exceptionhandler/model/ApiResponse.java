package cdu.zch.exceptionhandler.model;

import cdu.zch.exceptionhandler.constant.Status;
import cdu.zch.exceptionhandler.exception.BaseException;
import lombok.Data;

/**
 * @author Zch
 * 通用的API接口封装
 **/
@Data
public class ApiResponse {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造一个自定义API返回
     * @param code 状态码
     * @param message 返回消息
     * @param data 返回内容
     * @return ApiResponse
     */
    public static ApiResponse of(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * 请求成功且带数据的API返回
     * @param data 返回数据
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.OK, data);
    }

    /**
     * 请求成功且自定义消息的API返回
     * @param message 返回消息
     * @return ApiResponse
     */
    public static  ApiResponse ofMessage(String message) {
        return of(Status.OK.getCode(), message, null);
    }

    /**
     * 返回状态的API
     * @param status 自定义的状态 {@link Status}
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * 一个有状态且带数据的API
     * @param status 状态 {@link Status}
     * @param data 返回数据
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    /**
     * 一个异常且带数据的API
     * @param t 异常
     * @param data 返回数据
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return of(t.getCode(), t.getMessage(), data);
    }

    /**
     * 一个异常且带数据的API返回
     * @param t 异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }
}

package cdu.zch.demo16cos.exception;

import lombok.Data;

/**
 * @author Zch
 * @data 2023/4/26
 **/
@Data
public class DemoException extends RuntimeException {
    private String msg;
    private int code = 500;

    public DemoException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public DemoException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public DemoException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public DemoException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
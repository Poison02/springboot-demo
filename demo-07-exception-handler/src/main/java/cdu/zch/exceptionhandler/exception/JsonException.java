package cdu.zch.exceptionhandler.exception;

import cdu.zch.exceptionhandler.constant.Status;
import lombok.Getter;

/**
 * @author Zch
 **/
@Getter
public class JsonException extends BaseException{
    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}

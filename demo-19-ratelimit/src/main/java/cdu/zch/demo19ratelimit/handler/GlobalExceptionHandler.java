package cdu.zch.demo19ratelimit.handler;

import cn.hutool.core.lang.Dict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Zch
 * @data 2023/5/19
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Dict handler(RuntimeException exception) {
        return Dict.create().set("msg", exception.getMessage());
    }

}

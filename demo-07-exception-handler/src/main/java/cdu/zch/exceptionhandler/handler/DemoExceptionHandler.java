package cdu.zch.exceptionhandler.handler;

import cdu.zch.exceptionhandler.exception.JsonException;
import cdu.zch.exceptionhandler.exception.PageException;
import cdu.zch.exceptionhandler.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * @author Zch
 **/
@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一Json异常处理
     * @param exception JsonException
     * @return 同一返回Json格式
     *
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler(JsonException exception) {
        log.error("[JsonException]: {}", exception.getMessage());
        return ApiResponse.ofException(exception);
    }

    /**
     * 统一页面异常处理
     * @param exception PageException
     * @return 同一跳转到异常页面
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception) {
        log.error("[PageException]: {}", exception.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message", exception.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }
}

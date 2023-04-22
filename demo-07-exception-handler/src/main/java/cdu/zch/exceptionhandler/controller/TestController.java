package cdu.zch.exceptionhandler.controller;

import cdu.zch.exceptionhandler.constant.Status;
import cdu.zch.exceptionhandler.exception.JsonException;
import cdu.zch.exceptionhandler.exception.PageException;
import cdu.zch.exceptionhandler.model.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Zch
 **/
@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }

}

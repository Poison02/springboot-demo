package cdu.zch.captcha.controller;

import cdu.zch.captcha.result.CaptchaResult;
import cdu.zch.captcha.service.EasyCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zch
 * @date 2023/7/11
 **/
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private EasyCaptchaService easyCaptchaService;

    @GetMapping("/get")
    public Map<String, Object> getCaptcha() {
        Map<String, Object> result = new HashMap<>();
        CaptchaResult captchaResult = easyCaptchaService.getCaptcha();
        result.put("code", 200);
        result.put("data", captchaResult);
        return result;
    }

}

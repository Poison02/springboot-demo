package cdu.zch.captcha.service;

import cdu.zch.captcha.config.CaptchaConfig;
import cdu.zch.captcha.result.CaptchaResult;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Zch
 * @date 2023/7/11
 **/
@Component
public class EasyCaptchaService {

    @Autowired
    private EasyCaptchaProducer easyCaptchaProducer;

    @Autowired
    private CaptchaConfig captchaConfig;

    /**
     * 获取验证码
     * @return
     */
    public CaptchaResult getCaptcha() {
        // 获取验证码
        Captcha captcha = easyCaptchaProducer.getCaptcha();
        String captchaText = captcha.text(); // 验证码文本
        String captchaBase64 = captcha.toBase64(); // 验证码图片Base64字符串

        return CaptchaResult.builder()
                .verifyCodeKey(captchaText)
                .verifyCodeBase64(captchaBase64)
                .build();
    }

}

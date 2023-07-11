package cdu.zch.captcha.result;

import lombok.Builder;
import lombok.Data;

/**
 * @author Zch
 * @date 2023/7/11
 **/
@Data
@Builder
public class CaptchaResult {

    private String verifyCodeKey;

    private String verifyCodeBase64;

}

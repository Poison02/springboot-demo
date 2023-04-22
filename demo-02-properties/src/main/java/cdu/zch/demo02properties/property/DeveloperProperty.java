package cdu.zch.demo02properties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 **/
@Data
// @ConfigurationProperties(prefix = "developer")
@Component
public class DeveloperProperty {

    @Value("${developer.name}")
    private String name;

    @Value("${developer.website}")
    private String website;

    @Value("${developer.qq}")
    private String qq;

    @Value("${developer.phone-number}")
    private String phoneNumber;

}

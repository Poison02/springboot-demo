package cdu.zch.demo11nettysocketio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Zch
 **/
@Data
@ConfigurationProperties(prefix = "ws.server")
public class WsConfig {

    private Integer port;

    private String host;
}

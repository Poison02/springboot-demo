package cdu.zch.demo05logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 20698
 */
@SpringBootApplication
@Slf4j
public class Demo05LogbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo05LogbackApplication.class, args);
        int length = context.getBeanDefinitionNames().length;
        log.trace("Springboot 启动初始化了 {} 个 Bean", length);
        log.debug("Springboot 启动初始化了 {} 个 Bean", length);
        log.info("Springboot 启动初始化了 {} 个 Bean", length);
        log.warn("Springboot 启动初始化了 {} 个 Bean", length);
        log.error("Springboot 启动初始化了 {} 个 Bean", length);

        try {
            int i = 0;
            int j = 1 / i;
        } catch (Exception e) {
            log.error("[ERROR] SpringbootLogbackApplication 启动异常 ", e);
        }
    }

}

package cdu.zch.demo01hello;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 20698
 */
@SpringBootApplication
@RestController
public class Demo01HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo01HelloApplication.class, args);
    }

    @GetMapping("/helloWorld")
    public String hello(@RequestParam(required = false, name = "who") String who) {
        // 当who为空时，则赋值为World，否则传输入的值
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }

}

package cdu.zch.demo19ratelimit.controller;

import cdu.zch.demo19ratelimit.annotation.RateLimiter;
import cn.hutool.core.lang.Dict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 * @data 2023/5/19
 **/
@Slf4j
@RestController
public class TestController {

    @RateLimiter(value = 5)
    @GetMapping("/test1")
    public Dict test1() {
        log.info("[test1]被执行了！！！");
        return Dict.create().set("msg", "HelloWorld").set("description", "一直刷新试试！");
    }

    @GetMapping("/test2")
    public Dict test2() {
        log.info("[test2]被执行了！！！");
        return Dict.create().set("msg", "HelloWorld").set("description", "我一直在！！");
    }

    @RateLimiter(value = 2, key = "testSelfKey")
    @GetMapping("/test3")
    public Dict test3() {
        log.info("[test3]被执行了！！！");
        return Dict.create().set("msg", "HelloWorld").set("description", "一直刷新试试！！！");
    }

}

package cdu.zch.demo09redis;

import cdu.zch.demo09redis.entity.User;
import cdu.zch.demo09redis.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Demo09RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("hahaha", "value1");
        System.out.println(redisTemplate.opsForValue().get("hahaha"));
    }

    @Test
    public void test() {
        redisUtils.set("userxxx", "poison");
        System.out.println(redisUtils.get("userxxx"));
        redisUtils.set("useryyyyy", new User("xxxxx", "yyyyy"));
        System.out.println(redisUtils.get("useryyyyy"));
    }

}

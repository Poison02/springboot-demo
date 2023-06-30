package cdu.zch.demo21mybatisgeneratorpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cdu.zch.demo21mybatisgeneratorpage.mapper"})
public class Demo21MybatisGeneratorPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo21MybatisGeneratorPageApplication.class, args);
    }

}

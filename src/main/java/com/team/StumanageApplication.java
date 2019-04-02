package com.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  关于{DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}，可参考下行的网址
 * https://segmentfault.com/a/1190000015413813?utm_source=tag-newest
 * create by yifeng
 */
@SpringBootApplication(exclude=
        {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@RestController
public class StumanageApplication {


    public static void main(String[] args) {
        SpringApplication.run(StumanageApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

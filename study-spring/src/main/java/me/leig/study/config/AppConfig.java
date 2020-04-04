package me.leig.study.config;

import me.leig.study.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @title: AppConfig
 * @description:
 * @author: leig
 * @create: 2020-04-04 19:42
 **/
@Configuration
@ComponentScan(value = "me.leig.study")
public class AppConfig {

    @Bean
    public Person person() {
        return new Person("张三", 20);
    }

}

package me.leig.study.config;

import me.leig.study.aspects.LogAspects;
import me.leig.study.bean.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @title: AppConfigOfAOP
 * @description:
 * @author: leig
 * @create: 2020-04-06 20:54
 **/
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(value = {"me.leig.study"})
public class AppConfigOfAOP {

//    @Bean
//    public MathCalculator mathCalculator() {
//        return new MathCalculator();
//    }
//
//    @Bean
//    public LogAspects logAspects() {
//        return new LogAspects();
//    }

}

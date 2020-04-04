package me.leig.study;

import me.leig.study.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: Application
 * @description:
 * @author: leig
 * @create: 2020-04-04 19:42
 **/
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: definitionNames) {
            System.out.println("--> " + name);
        }

    }
}

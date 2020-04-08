package me.leig.study;

import me.leig.study.bean.MathCalculator;
import me.leig.study.config.AppConfigOfAOP;
import me.leig.study.config.TxConfig;
import me.leig.study.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: AppConfigOfAOPTest
 * @description:
 * @author: leig
 * @create: 2020-04-06 22:14
 **/
public class IOCTest_Tx {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    public void test() {
        printBean(applicationContext);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();
    }

    private void printBean(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
    }
}

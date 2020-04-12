package me.leig.study;

import me.leig.study.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: AppConfigOfAOPTest
 * @description:
 * @author: leig
 * @create: 2020-04-06 22:14
 **/
public class IOCTest_Ext {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

    @Test
    public void test() {
        printBean(applicationContext);
        applicationContext.close();
    }

    private void printBean(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
    }
}

package me.leig.study;

import me.leig.study.bean.MathCalculator;
import me.leig.study.config.AppConfigOfAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: AppConfigOfAOPTest
 * @description:
 * @author: leig
 * @create: 2020-04-06 22:14
 **/
public class AppConfigOfAOPTest {

    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigOfAOP.class);

    @Test
    public void test() {
        printBean(applicationContext);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10, 3);
    }

    private void printBean(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name: names) {
            System.out.println(name);
        }
    }
}

package me.leig.study;

import me.leig.study.bean.Person;
import me.leig.study.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title: ApplicationTest
 * @description:
 * @author: leig
 * @create: 2020-04-04 19:51
 **/
public class ApplicationTest {

    @Test
    public void springTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

}

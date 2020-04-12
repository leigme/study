package me.leig.study.ext;

import me.leig.study.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @title: MyBeanDefinitionRegistryPostProcessor
 * @description:
 * @author: leig
 * @create: 2020-04-13 00:19
 **/
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanDefinitionRegistry... Bean的数量: " + registry.getBeanDefinitionCount());
        registry.registerBeanDefinition("person", BeanDefinitionBuilder.rootBeanDefinition(Person.class).getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor... postProcessBeanFactory... Bean的数量: " + beanFactory.getBeanDefinitionCount());
    }
}

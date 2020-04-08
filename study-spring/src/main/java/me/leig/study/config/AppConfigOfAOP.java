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
 *
 * 1). @EnableAspectJAutoProxy 开启AOP功能
 * 2). @EnableAspectJAutoProxy 会向容器中注册一个 AnnotationAwareAspectJAutoProxyCreator 后置处理器
 * 3). 容器的创建过程
 *     1). registerBeanPostProcessors() 注册后置处理器，创建 AnnotationAwareAspectJAutoProxyCreator
 *     2). finishBeanFactoryInitialization() 初始化剩下的Bean
 *         1). 创建业务逻辑组件和切面组件
 *         2). AnnotationAwareAspectJAutoProxyCreator 拦截组件的创建过程
 *         3). 组件创建完成之后，判断组件是否需要增强
 *             是，切面的通知方法被包装成增强器(Advisor);给业务逻辑组件创建一个代理对象(cglib)
 * 4). 执行目标方法:
 *     1). 代理对象执行目标方法
 *     2). CglibAopProxy.intercept()
 *         1). 得到目标方法的拦截器链(增强器包装成拦截器 MethodInterceptor)
 *         2). 利用拦截器的链式机制，依次进入每一个拦截器执行
 *         3). 效果
 *             正常执行：前置通知-->目标方法-->后置通知-->返回通知
 *             异常执行：前置通知-->目标方法-->后置通知-->异常通知
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

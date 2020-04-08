package me.leig.study.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * @title: TxConfig
 * @description: 声明式事务
 * @author: leig
 * @create: 2020-04-08 21:53
 *
 * 1). @EnableTransactionManagement
 *      利用 TransactionManagementConfigurationSelector 给容器导入两个组件
 *          1). AutoProxyRegistrar
 *              注册一个 InfrastructureAdvisorAutoProxyCreator 后置处理器
 *              利用后置处理器机制在对象创建之后，包装对象，返回一个代理对象(增强器)，代理对象执行方法利用拦截器进行处理
 *          2). ProxyTransactionManagementConfiguration
 *              1). 给容器中注册事务增强器
 *                  1). 事务增强器要用事务注解的信息 AnnotationTransactionAttributeSource 解析事务注解
 *                  2). 事务拦截器 TransactionInterceptor 保存事务属性信息，保存事务管理器
 *                      本质是 MethodInterceptor 在目标方法执行的时候 执行拦截器链
 *                          事务拦截器:
 *                              1). 先获取事务属性
 *                              2). 再获取 PlatformTransactionManager 如果事先没有添加指定任何 TransactionManager
 *                              最终会从容器中按类型获取一个 PlatformTransactionManager
 *                              3). 执行目标方法
 *                                  如果异常，获取到事务管理器，利用事务管理器回滚操作
 *                                  如果正常，获取到事务管理器，利用事务管理器提交事务
 *
 **/
@EnableTransactionManagement
@ComponentScan(value = {"me.leig.study"})
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}

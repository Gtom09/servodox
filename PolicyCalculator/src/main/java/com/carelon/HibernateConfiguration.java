package com.carelon;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class HibernateConfiguration {
   /* @Value("${db.driver}")
    private String DRIVER;
 
    @Value("${db.password}")
    private String PASSWORD;
 
    @Value("${db.url}")
    private String URL;
 
    @Value("${db.username}")
    private String USERNAME;
 
    @Value("${hibernate.dialect}")
    private String DIALECT;
 
    @Value("${hibernate.show_sql}")
    private String SHOW_SQL;
 
    @Value("${hibernate.hbm2ddl.auto}")
    private String HBM2DDL_AUTO;
 
    @Value("${entitymanager.packagesToScan}")
    private String PACKAGES_TO_SCAN;*/
 
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@va33dx13v1-scan1.wellpoint.com:1525/ldsoldcased");
        dataSource.setUsername("POCDB");
        dataSource.setPassword("Pass#123");
        return dataSource;
    }
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
 
        return localSessionFactoryBean;
    }
 
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }   
}
 
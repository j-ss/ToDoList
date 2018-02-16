package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:db.properties"})
public class RepositoryConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource()
    {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(environment.getProperty("db.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        dataSource.setJdbcUrl(environment.getProperty("db.url"));
        dataSource.setUser(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        //conection pool size

        dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
        dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

        return dataSource;
    }

    private Properties getProperties()
    {
        Properties prop=new Properties();
        prop.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        prop.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        prop.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        return prop;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean()
    {
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(getProperties());
        sessionFactory.setPackagesToScan(environment.getProperty("hiberante.packagesToScan"));

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;

    }
}

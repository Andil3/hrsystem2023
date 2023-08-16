/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andile.hrsystem.persistence;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.andile.hrsystem.common.DatasourceUtility;

/**
 *
 * @author S2026080
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.andile.hrsystem.persistence"}, transactionManagerRef = "transactionManager")
@ComponentScan(basePackages = {"com.andile.hrsystem"})
@EnableTransactionManagement
public class DataSourceConfiguration {
    
    @Bean(name = "localContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        Map<String, Object> hibernateProps = new LinkedHashMap<>();
        hibernateProps.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        hibernateProps.put(org.hibernate.cfg.Environment.SHOW_SQL, false);
        hibernateProps.put(org.hibernate.cfg.Environment.FORMAT_SQL,false);
        hibernateProps.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        hibernateProps.put(org.hibernate.cfg.Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
        hibernateProps.put(org.hibernate.cfg.Environment.GENERATE_STATISTICS,false);
        hibernateProps.put(org.hibernate.cfg.Environment.DEFAULT_BATCH_FETCH_SIZE, 100);
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("server-persistence-unit");
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.andile.hrsystem.domain");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(hibernateProps);
        localContainerEntityManagerFactoryBean.setDataSource(DatasourceUtility.getDatasourceLookup());
         return localContainerEntityManagerFactoryBean;
    }
    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(@Qualifier("localContainerEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return entityManagerFactoryBean.getObject();
    }
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }  
    @Bean(name = "entityManager")
    public EntityManager entityManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
}

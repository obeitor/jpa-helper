package com.softobt.jpa.helpers.config;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public interface DataSourceSettings {
    LocalContainerEntityManagerFactoryBean dataEntityManagerFactory();
    DataSource dataSource();
    PlatformTransactionManager cloudTransactionManager();
}

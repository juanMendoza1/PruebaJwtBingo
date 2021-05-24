package com.io.develop.core.config_db;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.util.DriverDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bingoEntityManagerFactory",transactionManagerRef = "bingoTransactionManager",
basePackages = {"com.io.develop.core.juego.repo"})

public class Bingodb {

	@Autowired
	private Environment env;
	
	@Bean(name = "bingoDatasource")
	public DataSource bingoDatasource() {
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setUrl(env.getProperty("db2.datasource.url"));
		datasource.setUsername(env.getProperty("db2.datasource.username"));
		datasource.setPassword(env.getProperty("db2.datasource.password"));
		datasource.setDriverClassName(env.getProperty("db2.datasource.driver-class-name"));
		
		return datasource;
	}
	
	@Bean(name="bingoEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean loc= new LocalContainerEntityManagerFactoryBean();
		loc.setDataSource(bingoDatasource());
		loc.setPackagesToScan("com.io.develop.core.juego.modelo");
		
		HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
		loc.setJpaVendorAdapter(vendorAdapter);
		
		Map<String,Object> propiedades=new HashMap<>();
		propiedades.put("hibernate.show-sql", env.getProperty("db2.jpa.show-sql"));
		propiedades.put("hibernate.dialect", env.getProperty("db2.jpa.database-platform"));		
		loc.setJpaPropertyMap(propiedades);
		
		return loc;
	}
	
	@Bean(name="bingoTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tranManager=new JpaTransactionManager();
		tranManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return tranManager;
	}
	
}
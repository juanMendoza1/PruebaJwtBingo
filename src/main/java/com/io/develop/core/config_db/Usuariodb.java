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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "usuarioEntityManagerFactory",transactionManagerRef = "usuarioTransactionManager",
basePackages = {"com.io.develop.core.seguridad.repo"})

public class Usuariodb {
	
	@Autowired
	private Environment env;	
	
	@Primary
	@Bean(name = "usuarioDatasource")
	public DataSource usuarioDatasource() {
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		datasource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		
		return datasource;
	}
	
	@Primary
	@Bean(name="usuarioEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean loc= new LocalContainerEntityManagerFactoryBean();
		loc.setDataSource(usuarioDatasource());
		loc.setPackagesToScan("com.io.develop.core.seguridad.modelo");
		
		HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
		loc.setJpaVendorAdapter(vendorAdapter);
		
		Map<String,Object> propiedades=new HashMap<>();
		propiedades.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
		propiedades.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));		
		loc.setJpaPropertyMap(propiedades);
		
		return loc;
	}
	
	@Primary
	@Bean(name="usuarioTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tranManager=new JpaTransactionManager();
		tranManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return tranManager;
	}

}

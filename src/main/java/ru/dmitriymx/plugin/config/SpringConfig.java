package ru.dmitriymx.plugin.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ru.dmitriymx.plugin")
@EnableJpaRepositories(basePackages = "ru.dmitriymx.plugin.repository")
@EnableTransactionManagement
public class SpringConfig {

	@Value("${database.url}")
	private String databaseUrl;

	@Value("${database.user}")
	private String databaseUser;

	@Value("${database.password}")
	private String databasePassword;

	@Value("${database.hibernate.show-sql}")
	private String showSql;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(databaseUser);
		dataSource.setPassword(databasePassword);

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("ru.dmitriymx.plugin.entity");
		entityManagerFactoryBean.setJpaProperties(hibernateJpaProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

		return jpaTransactionManager;
	}

	private Properties hibernateJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		// показывать выполняемые SQL в логах
		properties.setProperty("hibernate.show_sql", showSql);

		// validate: проверяет соответствие схемы таблиц с имеющимися Entity классами
		// update: при необходимости, обновляет схемы таблиц в соответствии с имеющимися Entity классами
		// create: создаёт схемы таблиц, уничтожая имеющиеся данные
		// create-drop: уничтожает таблицы, если все соединения закрываются; обычно происходит при завершеннии работы приложения
		// none: ничего не делать
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
}

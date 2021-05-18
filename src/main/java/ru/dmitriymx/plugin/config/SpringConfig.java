package ru.dmitriymx.plugin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.dmitriymx.plugin")
public class SpringConfig {

	@Value("${database.url}")
	private String databaseUrl;

	@Value("${database.user}")
	private String databaseUser;

	@Value("${database.password}")
	private String databasePassword;

	//TODO для демонстрации
	@Bean("databaseUrl")
	public String getDatabaseUrl() {
		return databaseUrl;
	}
}

package br.com.desafioMv.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("br.com.desafioMv")
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

	@Autowired
	private Environment environment;

	private final String URL = "spring.datasource.url";
	private final String DRIVER = "spring.datasource.driver-class-name";

	private final String USER = "spring.datasource.username";
	private final String PASSWORD = "spring.datasource.password";

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setUrl(environment.getProperty(URL));
		driver.setUsername(environment.getProperty(USER));
		driver.setPassword(environment.getProperty(PASSWORD));
		driver.setDriverClassName(environment.getProperty(DRIVER));
		return driver;
	}
}
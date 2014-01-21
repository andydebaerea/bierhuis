package be.vdab.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@PropertySource("classpath:/database.properties")
public class CreateDAOBeans {
	@Autowired
	private Environment environment;
	
	@Bean(destroyMethod = "shutdown")
	HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName(environment
				.getProperty("database.dataSourceClassName"));
		config.addDataSourceProperty("url",
				environment.getProperty("database.url"));
		config.addDataSourceProperty("user",
				environment.getProperty("database.user"));
		config.addDataSourceProperty("password",
				environment.getProperty("database.password"));
		return new HikariDataSource(config);
	}
}

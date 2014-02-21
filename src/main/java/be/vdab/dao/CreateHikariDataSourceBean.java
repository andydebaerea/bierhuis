package be.vdab.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration

@Profile("test")
@PropertySource("classpath:/database.properties")
public class CreateHikariDataSourceBean {
	@Autowired
	private Environment environment;

	@Bean(/*destroyMethod = "shutdown"*/)
	
	DataSource dataSource() {
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

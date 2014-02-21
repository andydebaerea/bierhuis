package be.vdab.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@Profile("default")
public class CreateJndiDataSourceBean {
	@Bean
	DataSource dataSource() {
		return new JndiDataSourceLookup().getDataSource("java:comp/env/jdbc/bierhuisandy");
	}

}

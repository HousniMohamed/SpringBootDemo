package com.configs;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Housni Mohamed
 *
 */
@Configuration
public class JdbcTemplateConfig {

	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbctemplate")
	public JdbcTemplate getJdbTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}

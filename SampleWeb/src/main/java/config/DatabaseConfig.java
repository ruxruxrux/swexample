package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.UserDAO;

import org.apache.tomcat.jdbc.pool.DataSource;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource() {
		DataSource ds=new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/SW?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(10);
		ds.setMaxActive(20);
		
		System.out.println("db연결");
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		System.out.println("의존주입");
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public UserDAO userDAO() {
		return new UserDAO();
	}
	
}

package cn.yr.datasources.demodatasources.jta.atomikos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mysql.datasource.test2")
public class DBConfig2 {
	private String jdbcurl;
	private String username;
	private String password;
	public String getJdbcurl() {
		return jdbcurl;
	}
	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

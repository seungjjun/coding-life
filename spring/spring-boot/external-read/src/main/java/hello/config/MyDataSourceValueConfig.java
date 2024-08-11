package hello.config;

import hello.datasource.MyDataSource;
import java.time.Duration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {

	@Value("${my.datasource.username}")
	private String url;
	@Value("${my.datasource.username}")
	private String username;
	@Value("${my.datasource.passowrd}")
	private String password;
	@Value("${my.datasource.etc.max-conenction}")
	private int maxConnection;
	@Value("${my.datasource.etc.timeout}")
	private Duration timeout;
	@Value("${my.datasource.etc.options}")
	private List<String> options;

	@Bean
	public MyDataSource myDataSource() {
		return new MyDataSource(url, username, password, maxConnection, timeout, options);
	}

}

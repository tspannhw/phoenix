package com.dataflowdeveloper;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class HiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiveApplication.class, args);
	}

	// https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC
	@Configuration
	@Profile("default")
	static class LocalConfiguration {
		Logger logger = LoggerFactory.getLogger(LocalConfiguration.class);

	    @Value("${consumerkey}")
	    private String consumerKey;

	    @Value("${consumersecret}")
	    private String consumerSecret;
	    
	    @Value("${accesstoken}")
	    private String accessToken;
	    
	    @Value("${accesstokensecret}")
	    private String accessTokenSecret;
	    	
		@Bean
		public Twitter twitter() {
			Twitter twitter = null;
			
			try {
				twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
			} catch (Exception e) {
				logger.error("Error:", e);
			}
			
			return twitter;
		}

	    @Value("${hiveuri}")
	    private String databaseUri;
	    
	    @Value("${hiveusername}")
	    private String username;
	    
		@Bean
		public DataSource dataSource() {
			
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setUrl(databaseUri);
			dataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
			dataSource.setUsername(username);
			// dataSource.setPassword(password);
			logger.error("Initialized Hive");
			
			return dataSource;
		}
	}
}

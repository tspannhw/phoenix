package com.dataflowdeveloper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

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
public class HBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HBaseApplication.class, args);
	}

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

	    @Value("${purl}")
	    private String databaseUri;
	    	    
		@Bean
		public Connection connection() {
		        Connection con = null;
				try {
					con = DriverManager.getConnection(databaseUri);
				} catch (SQLException e) {
					logger.error("Connection fail: ", e);
				}
	
			//dataSource.setDriverClassName("org.apache.phoenix.jdbc.PhoenixDriver");
			logger.error("Initialized hbase");
			
			return con;
		}
	}
}

package com.dataflowdeveloper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("DataSourceService")
public class DataSourceService {

	Logger logger = LoggerFactory.getLogger(DataSourceService.class);

	@Autowired
	public DataSource dataSource;
	
	// default to empty
	public Twitter2 defaultValue() {
		return new Twitter2();
	}

	/**
	 * 
	 * @param query - search msg
	 * @return List of Twitter2
	 */
	public List<Twitter2> search(String query) {
		if ( query == null) { return null; }
		
		List<Twitter2> tweets = new ArrayList<>();
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet res = stmt.executeQuery("select * from sparktwitterorc where msg like '%water%' LIMIT 100");
			Twitter2 tweet = null;
			    while (res.next()) {
			      System.out.println(res.getString(1) + "," + res.getString(2) + "," + res.getString(3) + 
			    		  "," + res.getString(4) + "," + res.getString(5));
			      tweet = new Twitter2();
			      tweet.setMsg(res.getString(2) + "," + res.getString(3));
			      tweets.add(tweet);
			    }
			    
			    
			    res.close();
			    stmt.close();
			    connection.close();
			    res = null;
			    stmt = null;
			    connection = null;
			    
			    /**
			     *    PreparedStatement ps = conn.prepareStatement( "select * from sparktwitterorc WHERE msg like ?" ) ;

      // Set the first parameter of the statement
      ps.setString( 1, "Meier" ) ;

      // Execute the query
      ResultSet rs = ps.executeQuery() ;


			     */
			logger.error("Size=" + tweets.size());
		} catch (Exception e) {
			logger.error("Error in search", e);
		}

		return tweets;
	}

}

package com.dataflowdeveloper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	// querylimit
	@Value("${querylimit}")
	private String querylimit;

	/**
	 * 
	 * @param query
	 *            - search msg
	 * @return List of Twitter2
	 */
	public List<Twitter2> search(String query) {
		if (query == null) {
			return null;
		}

		List<Twitter2> tweets = new ArrayList<>();
		try {
			logger.error("Query: " + query);
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from sparktwitterorc WHERE msg like ? LIMIT ?");
			ps.setString(1, "%" + query + "%");
			ps.setInt(2, Integer.parseInt(querylimit));
			ResultSet res = ps.executeQuery();
			Twitter2 tweet = null;
			while (res.next()) {
				tweet = new Twitter2();
				tweet.setMsg(res.getString("msg"));
				tweet.setHandle(res.getString("handle"));
				tweet.setLocation(res.getString("location"));
				tweet.setCoordinates(res.getString("coordinates"));
				tweet.setFollowers_count(res.getString("followers_count"));
				tweet.setGeo(res.getString("geo"));
				tweet.setHashtags(res.getString("hashtags"));
				tweet.setLanguage(res.getString("language"));
				tweet.setPlace(res.getString("place"));
				tweet.setProfile_image_url(res.getString("profile_image_url"));
				tweet.setRetweet_count(res.getString("retweet_count"));
				tweet.setSentiment(res.getString("sentiment"));
				tweet.setSource(res.getString("source"));
				tweet.setTag(res.getString("tag"));
				tweet.setTime(res.getString("time"));
				tweet.setTag(res.getString("tag"));
				tweet.setTime_zone(res.getString("time_zone"));
				tweet.setTweet_id(res.getString("tweet_id"));
				tweet.setUnixtime(res.getString("unixtime"));
				tweet.setUser_name(res.getString("user_name"));
				tweets.add(tweet);
			}

			res.close();
			ps.close();
			connection.close();
			res = null;
			ps = null;
			connection = null;
			tweet = null;

			logger.error("Size=" + tweets.size());
		} catch (Exception e) {
			logger.error("Error in search", e);
		}

		return tweets;
	}
}

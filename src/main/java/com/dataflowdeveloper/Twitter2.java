package com.dataflowdeveloper;

import java.io.Serializable;

//"sparktwitterorc"
public class Twitter2 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7409772495079484269L;

	private String geo;

	private String unixtime;

	private String handle;

	private String location;

	private String tag;

	private String tweet_id;

	public Twitter2(String geo, String unixtime, String handle, String location, String tag, String tweet_id,
			String msg, String time_zone, String sentiment, String user_name, String time, String source,
			String friends_count, String retweet_count, String hashtags, String language, String place,
			String followers_count, String profile_image_url, String coordinates) {
		super();
		this.geo = geo;
		this.unixtime = unixtime;
		this.handle = handle;
		this.location = location;
		this.tag = tag;
		this.tweet_id = tweet_id;
		this.msg = msg;
		this.time_zone = time_zone;
		this.sentiment = sentiment;
		this.user_name = user_name;
		this.time = time;
		this.source = source;
		this.friends_count = friends_count;
		this.retweet_count = retweet_count;
		this.hashtags = hashtags;
		this.language = language;
		this.place = place;
		this.followers_count = followers_count;
		this.profile_image_url = profile_image_url;
		this.coordinates = coordinates;
	}

	public Twitter2() {
		super();
	}

	private String msg = "";

	private String time_zone;

	private String sentiment;

	private String user_name;

	private String time;

	private String source;

	private String friends_count;

	private String retweet_count;

	private String hashtags;

	private String language;

	private String place;

	private String followers_count;

	private String profile_image_url;

	private String coordinates;

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(String unixtime) {
		this.unixtime = unixtime;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(String tweet_id) {
		this.tweet_id = tweet_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(String friends_count) {
		this.friends_count = friends_count;
	}

	public String getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(String retweet_count) {
		this.retweet_count = retweet_count;
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Twitter2 [geo=");
		builder.append(geo);
		builder.append(", unixtime=");
		builder.append(unixtime);
		builder.append(", handle=");
		builder.append(handle);
		builder.append(", location=");
		builder.append(location);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", tweet_id=");
		builder.append(tweet_id);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", time_zone=");
		builder.append(time_zone);
		builder.append(", sentiment=");
		builder.append(sentiment);
		builder.append(", user_name=");
		builder.append(user_name);
		builder.append(", time=");
		builder.append(time);
		builder.append(", source=");
		builder.append(source);
		builder.append(", friends_count=");
		builder.append(friends_count);
		builder.append(", retweet_count=");
		builder.append(retweet_count);
		builder.append(", hashtags=");
		builder.append(hashtags);
		builder.append(", language=");
		builder.append(language);
		builder.append(", place=");
		builder.append(place);
		builder.append(", followers_count=");
		builder.append(followers_count);
		builder.append(", profile_image_url=");
		builder.append(profile_image_url);
		builder.append(", coordinates=");
		builder.append(coordinates);
		builder.append("]");
		return builder.toString();
	}
}
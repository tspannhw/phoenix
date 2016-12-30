package com.dataflowdeveloper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author tspann
 *
 */
@RestController
public class DataController {

	public static HttpServletRequest getCurrentRequest() {
	     RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
	     Assert.state(requestAttributes != null, "Could not find current request via RequestContextHolder");
	     Assert.isInstanceOf(ServletRequestAttributes.class, requestAttributes);
	     HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
	     Assert.state(servletRequest != null, "Could not find current HttpServletRequest");
	     return servletRequest;
	 }    
	
	Logger logger = LoggerFactory.getLogger(DataController.class);

	@Autowired
	private DataSourceService dataSourceService;
	
    private static final String twitterView = "Twitter User: %s";
   
    @Autowired
    private TwitterService twitterService;

 @RequestMapping(value = "/timeline/{twitterUser}")
 public List<Tweet> getUserTimeline(@PathVariable String twitterUser) {
 	String inputValue = String.format(twitterView, twitterUser);
	logger.error(inputValue);
    return twitterService.getUserTimeline(twitterUser);
 }

    @RequestMapping(value = "/profile/{twitterUser}")
    public TwitterProfile getUserProfile(@PathVariable String twitterUser) {
        return twitterService.getUserProfile(twitterUser);
    }
    
    @RequestMapping("/query/{query}")
    public List<PhillyCrime> query(
    		@PathVariable(value="query") String query) 
    {
    	List<PhillyCrime> value = dataSourceService.search(query);
    	final String userIpAddress = getCurrentRequest().getRemoteAddr();
    	final String userAgent = getCurrentRequest().getHeader("user-agent");
    	final String userDisplay = String.format("Query:%s,IP:%s Browser:%s", query, userIpAddress, userAgent);
    	logger.error(userDisplay);
        return value;
    }
}
package com.dataflowdeveloper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.UserOperations;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {

   @Autowired
    private Twitter twitter;


   /**
    * 
    * @param twitterUser
    * @return
    */
    public List <Tweet> getUserTimeline(String twitterUser) {
        TimelineOperations timelineOps = twitter.timelineOperations();
        List<Tweet> tweets = timelineOps.getUserTimeline("@" + twitterUser);

        return tweets;
    }

    /**
     * 
     * @param twitterUser
     * @return
     */
    public TwitterProfile getUserProfile(String twitterUser) {
        UserOperations userOperations = twitter.userOperations();
        TwitterProfile userProfile = userOperations.getUserProfile(twitterUser);
        return userProfile;
    }
}

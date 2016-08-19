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

// Consumer Key (API Key)	  ql09tgU1MhvwJAsmI9vIYPxTB
//Consumer Secret (API Secret)      4k7QphoGGlKBAsyhW9T9yKPYmlZ80djmAxRBPTithBSBNNN7F1
//Access Token                      1006391-Yf9r2kVrblGnJeuZFdaj1vaATOB3wb707RUNqZlhOG
//Access Token Secret               RZRsh4F1Td9gVX4W2KFnJk1JLTzkKWsjxGVEbNwuHxg26
   
    public List <Tweet> getUserTimeline(String twitterUser) {
        TimelineOperations timelineOps = twitter.timelineOperations();
        List<Tweet> tweets = timelineOps.getUserTimeline("@" + twitterUser);

        return tweets;
    }

    public TwitterProfile getUserProfile(String twitterUser) {
        UserOperations userOperations = twitter.userOperations();
        TwitterProfile userProfile = userOperations.getUserProfile(twitterUser);
        return userProfile;
    }
}
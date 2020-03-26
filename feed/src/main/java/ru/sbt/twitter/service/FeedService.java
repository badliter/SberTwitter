package ru.sbt.twitter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.twitter.dto.FeedDTO;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.OwnerSubscriptions;
import ru.sbt.twitter.entity.Tweet;
import ru.sbt.twitter.entity.User;
import ru.sbt.twitter.repository.FeedRepository;
import ru.sbt.twitter.repository.SubscribersRepository;
import ru.sbt.twitter.repository.UsersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final RestTemplate template;
    @Autowired
    private final FeedRepository feedRepository;
    @Autowired
    private final SubscribersRepository subsRepository;
    @Autowired
    private final UsersRepository usersRepository;

    public List<FeedDTOInterface> getFeed(Long ownerId) {
        List<FeedDTOInterface> news = feedRepository.findFeedByOwnerId(ownerId);
        return news;
    }

    public Set<Tweet> getTweets(Long userId) {
        Set<Tweet> tweets = feedRepository.findByUserid(userId);
        return tweets;
    }

    public void addSubscriber(OwnerSubscriptions sub) {
        subsRepository.save(sub);
    }

    public void addTweet(Tweet tweet) {
        feedRepository.save(tweet);
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public User getUserInfoById(Long userId) {
        return usersRepository.findByUserid(userId);
    }

    public List<Tweet> getTweetsOnline(Long userId){
        Long[] users = template.getForEntity(
                "http://subscribers/getsubscriptions/" + userId, Long[].class).getBody();
        List<Tweet> allTweets = new ArrayList<>();
        for (Long user : users) {
            Tweet[] tweets = template.getForEntity(
                    "http://tweets/getalltweets/" + user, Tweet[].class).getBody();
            allTweets.addAll(Arrays.asList(tweets));
        }
        return allTweets;
    }

    public User getUserFromReg(Long userid) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = template.getForEntity("http://registration/getUser/"+userid, String.class).getBody();
        User vo = objectMapper.readValue(json, User.class);
        return vo;
    }

    public List<FeedDTO> getFeedOnline(Long userId) throws JsonProcessingException {
        List<Tweet> allTweets = getTweetsOnline(userId);
        List<FeedDTO> feed = new ArrayList<>();
        for (Tweet tweet:allTweets) {
            feed.add(new FeedDTO(tweet, getUserFromReg(tweet.getUserid())));
        }
        return feed;
    }
}

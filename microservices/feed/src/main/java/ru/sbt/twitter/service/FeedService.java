package ru.sbt.twitter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.OwnerSubscriptions;
import ru.sbt.twitter.entity.Tweet;
import ru.sbt.twitter.entity.User;
import ru.sbt.twitter.repository.FeedRepository;
import ru.sbt.twitter.repository.SubscribersRepository;
import ru.sbt.twitter.repository.UsersRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FeedService {
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
    public Set<Tweet> getTweets (Long userId){
        Set<Tweet> tweets = feedRepository.findByUserid(userId);
        return tweets;
    }
    public void addSubscriber(OwnerSubscriptions sub){
        subsRepository.save(sub);
    }
    public User getUserInfoById(Long userId){
        return usersRepository.findByUserid(userId);
    }

}

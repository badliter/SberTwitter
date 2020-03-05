package ru.sbt.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.twitter.entity.FeedEntity;
import ru.sbt.twitter.repository.FeedRepository;

import java.util.List;

@Service
public class FeedService {
    @Autowired
    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<FeedEntity> getFeed(Long user_id){
        List<FeedEntity> news = feedRepository.findByUser_id(user_id);
        return news;
    }
}

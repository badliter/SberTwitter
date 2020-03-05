package ru.sbt.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbt.twitter.entity.FeedTable;
import ru.sbt.twitter.repository.FeedRepositoryImpl;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private final FeedRepositoryImpl feedRepository;

    public FeedService(FeedRepositoryImpl feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<FeedTable> getFeed(Long user_id) {
        List<FeedTable> news = feedRepository.findFeedTablesByUser_id(user_id);
        return news;
    }
}

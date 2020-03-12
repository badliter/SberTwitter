package ru.sbt.twitter.feed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.twitter.feed.entity.FeedTable;

import java.util.List;

public interface FeedRepositoryImpl extends JpaRepository<FeedTable, Long> {
    List<FeedTable> findByOwnerid(Long ownerId);
}

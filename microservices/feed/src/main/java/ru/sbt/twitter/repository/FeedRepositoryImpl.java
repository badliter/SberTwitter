package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.twitter.entity.FeedTable;

import java.util.List;

public interface FeedRepositoryImpl extends JpaRepository<FeedTable, Long> {
    List<FeedTable> findFeedTablesByUser_id(Long user_id);
}

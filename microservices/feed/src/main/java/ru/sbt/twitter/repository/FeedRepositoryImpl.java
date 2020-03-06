package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.sbt.twitter.entity.FeedTable;

import java.util.List;

public interface FeedRepositoryImpl extends JpaRepository<FeedTable, Long> {
    List<FeedTable> findByOwnerid(Long ownerId);
}

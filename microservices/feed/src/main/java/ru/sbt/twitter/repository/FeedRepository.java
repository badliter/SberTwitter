package ru.sbt.twitter.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.twitter.entity.FeedEntity;

import java.util.List;

public interface FeedRepository extends JpaRepository<FeedEntity, List<Long>> {
    List<FeedEntity> findByUser_id(Long user_id);
}

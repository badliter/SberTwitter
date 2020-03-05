package ru.sbt.twitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<FeedEntity, List<Long>> {
    List<FeedEntity> findByUser_id(Long user_id);
}

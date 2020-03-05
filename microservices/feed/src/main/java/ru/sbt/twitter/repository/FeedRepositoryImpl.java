package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.Tweets;

import java.util.List;

public interface FeedRepositoryImpl extends JpaRepository<Tweets, Long> {
    @Query(value = "select t.userid, t.tweetid, t.content,t.date, e.login, e.firstname, e.lastname\n" +
            "from feed_cfg.tweets t left join feed_cfg.usersinfo e on t.userid = e.userid\n" +
            "where t.userId = :userId",
            nativeQuery = true)
    List<FeedDTOInterface> findByUserId(@Param("userId") Long userId);
}

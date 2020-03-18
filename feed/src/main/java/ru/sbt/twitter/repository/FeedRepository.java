package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sbt.twitter.dto.FeedDTOInterface;
import ru.sbt.twitter.entity.Tweet;

import java.util.List;
import java.util.Set;

public interface FeedRepository extends JpaRepository<Tweet, Long> {
    @Query(value = " SELECT  own.ownerid, own.userid, t.tweetid, t.content, t.date, u.login, u.firstname, u.lastname " +
            " FROM feed_cfg.ownersubscriptions own left join feed_cfg.tweets t on own.userid = t.userid  " +
            "  LEFT JOIN feed_cfg.usersinfo u on own.userid = u.userid" +
            " WHERE own.ownerid = :ownerId ",
            nativeQuery = true)
    List<FeedDTOInterface> findFeedByOwnerId(@Param("ownerId") Long userId);
    Set<Tweet> findByUserid(Long userId);
}

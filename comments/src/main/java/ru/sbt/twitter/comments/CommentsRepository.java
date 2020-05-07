package ru.sbt.twitter.comments;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;


public interface CommentsRepository extends CrudRepository<Comment, Integer> {
    @Query("SELECT * FROM comments WHERE tweet_id=?0 ORDER BY timestamp ASC;")
    Slice<Comment> getCommentsBatch(int id, Pageable pageable);
}
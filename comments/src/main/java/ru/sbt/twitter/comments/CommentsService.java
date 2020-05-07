package ru.sbt.twitter.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.data.cassandra.core.query.CassandraPageRequest.first;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public List<Comment> getComments(int tweetId, int page, int size) {
        Slice<Comment> commentsBatch = commentsRepository.getCommentsBatch(tweetId, first(size));
        if (page == 0) return commentsBatch.getContent();

        int current = 0;
        Slice<Comment> currentBatch = commentsBatch;
        while (current < page) {
            if (!currentBatch.hasNext()) return emptyList();
            currentBatch = commentsRepository.getCommentsBatch(tweetId, currentBatch.nextPageable());
            current++;
        }
        return currentBatch.getContent();
    }
}
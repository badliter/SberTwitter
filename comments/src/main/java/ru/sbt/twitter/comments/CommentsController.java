package ru.sbt.twitter.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.cassandra.core.query.CassandraPageRequest.of;

@RestController
@RequiredArgsConstructor
public class CommentsController {
    private final CommentsService commentsService;

    @GetMapping("/comments")
    private List<Comment> getComments(@RequestParam int tweetId,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "50") int size) {
        return commentsService.getComments(tweetId, page, size);
    }
}
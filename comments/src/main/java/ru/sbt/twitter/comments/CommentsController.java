package ru.sbt.twitter.comments;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
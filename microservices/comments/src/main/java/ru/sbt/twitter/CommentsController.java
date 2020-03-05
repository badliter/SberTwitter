package ru.sbt.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @GetMapping("/comments")
    private List<Comment> getAllComments() {
        return commentsService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    private Comment getCommentById(@PathVariable("id") int id) {
        return commentsService.getCommentById(id);
    }

    @DeleteMapping("/comments/{id}")
    private void deleteComment(@PathVariable("id") int id) {
        commentsService.delete(id);
    }

    @PostMapping("/comments")
    private int saveComment(@RequestBody Comment comment) {
        commentsService.saveOrUpdate(comment);
        return comment.getId();
    }
}
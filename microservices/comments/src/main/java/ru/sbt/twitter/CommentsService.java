package ru.sbt.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsRepository commentsRepository;

    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        commentsRepository.findAll().forEach(comments::add);
        return comments;
    }

    public Comment getCommentById(int id) {
        return commentsRepository.findById(id).orElse(null);
    }

    public void saveOrUpdate(Comment comment) {
        commentsRepository.save(comment);
    }

    public void delete(int id) {
        commentsRepository.deleteById(id);
    }
}
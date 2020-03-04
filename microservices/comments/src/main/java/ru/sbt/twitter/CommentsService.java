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
        commentsRepository.findAll().forEach(person -> comments.add(person));
        return comments;
    }

    public Comment getCommentById(int id) {
        System.out.println("getting");
        return commentsRepository.findById(id).get();
    }

    public void saveOrUpdate(Comment person) {
        commentsRepository.save(person);
    }

    public void delete(int id) {
        commentsRepository.deleteById(id);
    }
}
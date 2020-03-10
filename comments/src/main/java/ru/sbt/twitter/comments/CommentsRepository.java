package ru.sbt.twitter.comments;

import org.springframework.data.repository.CrudRepository;


public interface CommentsRepository extends CrudRepository<Comment, Integer> {
}
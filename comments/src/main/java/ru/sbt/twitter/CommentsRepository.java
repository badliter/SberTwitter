package ru.sbt.twitter;

import org.springframework.data.repository.CrudRepository;


public interface CommentsRepository extends CrudRepository<Comment, Integer> {
}
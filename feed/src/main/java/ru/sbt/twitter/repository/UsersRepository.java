package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.twitter.entity.User;


public interface UsersRepository extends JpaRepository<User, Long> {
    public User findByUserid(Long userId);
}

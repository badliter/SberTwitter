package ru.sbt.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.twitter.entity.OwnerSubscriptions;

public interface SubscribersRepository extends JpaRepository<OwnerSubscriptions, Long> {
    public OwnerSubscriptions findByOwnerid(Long ownerId);
}

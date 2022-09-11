package com.example.learnredis.repository;

import com.example.learnredis.entity.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRedisRepository extends CrudRepository<People,String> {
}

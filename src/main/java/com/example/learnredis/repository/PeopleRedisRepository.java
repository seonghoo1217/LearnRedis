package com.example.learnredis.repository;

import com.example.learnredis.model.entity.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRedisRepository extends CrudRepository<People,String> {
}

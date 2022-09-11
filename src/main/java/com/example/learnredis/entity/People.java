package com.example.learnredis.entity;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people",timeToLive = 30)
public class People {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createdAt;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}

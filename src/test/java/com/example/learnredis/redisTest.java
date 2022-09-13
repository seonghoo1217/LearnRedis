package com.example.learnredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class redisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    void testString(){
        //given
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        String key="ThisIsKey";

        //when
        valueOperations.set(key,"Hello");
        //then
        String S = valueOperations.get(key);
        assertThat(S).isEqualTo("Hello");
    }

    @Test
    void testSet(){

        //given
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key="keySet";

        //when
        setOperations.add(key,"h","e","l","l","o");
        //then
        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);

        assertThat(members).containsOnly("h","e");
        assertThat(size).isEqualTo(5);
    }

    @Test
    public void testHash(){
        //given
        HashOperations<String, Object, Object> has = redisTemplate.opsForHash();
        String key="hashKey";
        //when
        has.put(key,"hello","world");
        //then
        Object value = has.get(key, "hello");
        assertThat(value).isEqualTo("world");

        Map<Object, Object> entries = has.entries(key);
        assertThat(entries.keySet()).containsExactly("hello");
        assertThat(entries.keySet()).containsOnly("hello");
        assertThat(entries.values()).containsExactly("world");

        Long size = has.size(key);
        System.out.println("size="+size);
        System.out.println("Esize="+entries.size());
        assertThat(size).isEqualTo(entries.size());

    }

}

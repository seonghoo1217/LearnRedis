package com.example.learnredis.service;

import com.example.learnredis.model.dto.PeopleDTO;
import com.example.learnredis.model.entity.People;
import com.example.learnredis.repository.PeopleRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PeopleRedisService {

    private final PeopleRedisRepository peopleRedisRepository;

    @Transactional
    public void createPeople(PeopleDTO.SavePeopleDTO savePeopleDTO){
        peopleRedisRepository.save(savePeopleDTO.toEntity());
    }

    public People getPeopleById(String id){
        return peopleRedisRepository.findById(id).orElseThrow(()->new NoSuchElementException("값이 없음"));
    }

    @Transactional
    public long getKeysCount(){
        return peopleRedisRepository.count();
    }
}

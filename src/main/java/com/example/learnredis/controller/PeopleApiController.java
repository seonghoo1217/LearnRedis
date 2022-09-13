package com.example.learnredis.controller;

import com.example.learnredis.model.dto.PeopleDTO;
import com.example.learnredis.model.entity.People;
import com.example.learnredis.service.PeopleRedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PeopleApiController {

    private final PeopleRedisService peopleRedisService;

    @PostMapping("/savePeople")
    public ResponseEntity<?> savePeopleApi(@RequestBody PeopleDTO.SavePeopleDTO savePeopleDTO){
        peopleRedisService.createPeople(savePeopleDTO);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }

    @GetMapping("/getPeople")
    public ResponseEntity<People> getPeopleApi(@RequestParam("id")String id){
        People findPeople = peopleRedisService.getPeopleById(id);
        return new ResponseEntity<>(findPeople,HttpStatus.OK);
    }

    @GetMapping("/getCounts")
    public ResponseEntity<Long> getCountsKeyAPi(){
        long keysCount = peopleRedisService.getKeysCount();
        return new ResponseEntity<>(keysCount,HttpStatus.OK);
    }
}

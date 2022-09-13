package com.example.learnredis.model.dto;

import com.example.learnredis.model.entity.People;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PeopleDTO {

    @Getter
    @Setter
    public static class SavePeopleDTO{
        private String id;
        private String name;
        private Integer age;


        public People toEntity(){
            return People.builder()
                    .name(name)
                    .age(age)
                    .build();
        }
    }
}

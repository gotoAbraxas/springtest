package com.example.demo1.member.response;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.hobby.domain.response.HobbyResponse;
import com.example.demo1.member.entity.Member;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
    private Integer age;
    private List<HobbyDto> hobbyDtoList;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
        this.hobbyDtoList = member.getHobbies().stream().map(HobbyDto::new).toList();
    }
    @Getter
    @AllArgsConstructor
    class HobbyDto{
        private Long id;
        private String name;

        public HobbyDto(Hobby hobby){
            this.id = hobby.getId();
            this.name= hobby.getName();
        }
    }
}

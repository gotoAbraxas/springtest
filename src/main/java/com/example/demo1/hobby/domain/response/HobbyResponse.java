package com.example.demo1.hobby.domain.response;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.joiner.domain.MemberHobby;
import com.example.demo1.member.response.MemberResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HobbyResponse {

    private Long id;
    private String name;
    private MemberDto memberDto;

    public HobbyResponse(MemberHobby memberHobby) {
        this.id = memberHobby.getHobby().getId();
        this.name = memberHobby.getHobby().getName();
        this.memberDto = new MemberDto(memberHobby);
    }

    @Getter
    @AllArgsConstructor
    class MemberDto{
        private Long id;
        private String name;
        private Integer age;

        public MemberDto(MemberHobby memberHobby) {
            this.id = memberHobby.getMember().getId();
            this.name = memberHobby.getMember().getName();
            this.age = memberHobby.getMember().getAge();
        }
    }
}

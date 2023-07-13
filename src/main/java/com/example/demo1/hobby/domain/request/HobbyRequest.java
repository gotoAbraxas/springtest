package com.example.demo1.hobby.domain.request;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HobbyRequest {

    private  String name;
}

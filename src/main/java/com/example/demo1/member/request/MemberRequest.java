package com.example.demo1.member.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberRequest {

    private final String name;
    private final Integer age;
}

package com.example.demo1.member.entity;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.joiner.domain.MemberHobby;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="members")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

//    @OneToMany(mappedBy = "member", fetch =  FetchType.EAGER) // 한번에 싹다 데이터를 가져옴
    @OneToMany(mappedBy = "member")
    private List<MemberHobby> memberHobby;
}

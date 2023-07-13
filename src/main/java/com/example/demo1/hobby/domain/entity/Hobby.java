package com.example.demo1.hobby.domain.entity;

import com.example.demo1.joiner.domain.MemberHobby;
import com.example.demo1.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
// jakarta.persistence api -> jpa


@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name ="hobbies")
public class Hobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "hobby")
    private List<MemberHobby> memberHobby;
}

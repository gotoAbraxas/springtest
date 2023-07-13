package com.example.demo1.joiner.domain;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="memberHoby")
public class MemberHobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Hobby hobby;
}

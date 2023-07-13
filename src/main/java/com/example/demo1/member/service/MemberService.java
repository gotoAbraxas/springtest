package com.example.demo1.member.service;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.hobby.domain.response.HobbyResponse;
import com.example.demo1.member.entity.Member;
import com.example.demo1.member.request.MemberRequest;
import com.example.demo1.member.response.MemberResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final EntityManager em;

    public void save(MemberRequest memberRequest){
        Member member = Member
                .builder()
                .id(null)
                .name(memberRequest.getName())
                .age(memberRequest.getAge()).build();

        em.persist(member);
    }

    public List<MemberResponse> findAll(){ // jpql이다.

        return em.createQuery("select  m from Member m " +
                        "join fetch m.hobbies", Member.class)
                .getResultList().stream().map(MemberResponse::new).toList();
    }

    public MemberResponse findById(Long id){
       return new MemberResponse(em.find(Member.class, id));
    }

    public List<MemberResponse> findByName(String name){
        return em.createQuery("select  m from Member m WHERE m.name like :name ", Member.class)
                .setParameter("name","%"+name+"%")
                .getResultList().stream().map(MemberResponse::new).toList();
    }


    public void deleteById(Long id){
        em.remove(findById(id));
    }

    public void update(Long id,MemberRequest member){
        Member member1 = em.find(Member.class, id);
        member1.setAge(member.getAge());
        member1.setName(member.getName());
        System.out.println("merge");

//        Member member1 = new Member(id, member.getName(), member.getAge());
//        em.merge(member1);

//        member1.setAge(member.getAge());
//        member1.setName(member.getName());
      //  em.flush();
    }
}

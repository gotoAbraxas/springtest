package com.example.demo1.hobby.service;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.hobby.domain.request.HobbyRequest;
import com.example.demo1.hobby.domain.response.HobbyResponse;
import com.example.demo1.member.entity.Member;
import com.example.demo1.member.request.MemberRequest;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HobbyService {
    private final EntityManager em;

    public void save(HobbyRequest hobbyRequest){
        em.persist(hobbyRequest);

    }

    public List<HobbyResponse> findAll(){ // jpql이다.
        List<HobbyResponse> hobbyResponses = em.createQuery("select  h from Hobby h", Hobby.class)
                .getResultList().stream().map(HobbyResponse::new).toList();

        return hobbyResponses;
    }

    public HobbyResponse findById(Long id){
//        Hobby hobby = em.find(Hobby.class,id);
        Hobby hobby = em.find(Hobby.class, id);
        return new HobbyResponse();
    }

    public void deleteById(Long id){
        em.remove(findById(id));
    }

    public void update(Long id, HobbyRequest hobbyRequest) {
        Hobby hobby = em.find(Hobby.class, id);
        hobby.setName(hobbyRequest.getName());
    }


}

package com.example.demo1.member.controller;

import com.example.demo1.member.entity.Member;
import com.example.demo1.member.request.MemberRequest;
import com.example.demo1.member.response.MemberResponse;
import com.example.demo1.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void save(@RequestBody MemberRequest memberRequest){
        memberService.save(memberRequest);
    }

    @GetMapping
    public List<MemberResponse> findAll(@RequestParam(value = "name",required = false) String name){
        if(name == null || name.equals("")) {
            return memberService.findAll();
        }else {
            return memberService.findByName(name);
        }
    }


    @GetMapping("{id}")
    public MemberResponse findById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        memberService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable("id") Long id,
                           @RequestBody MemberRequest memberRequest ){
        memberService.update(id,memberRequest);
    }

}

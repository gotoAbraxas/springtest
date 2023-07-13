package com.example.demo1.hobby.controller;

import com.example.demo1.hobby.domain.entity.Hobby;
import com.example.demo1.hobby.domain.request.HobbyRequest;
import com.example.demo1.hobby.domain.response.HobbyResponse;
import com.example.demo1.hobby.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobbies")
public class HobbyController {
    private final HobbyService service;

    @PostMapping
    public void save(@RequestBody HobbyRequest hobbyRequest){

        service.save(hobbyRequest);
    }

    @GetMapping
    public List<HobbyResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public HobbyResponse findById(@PathVariable("id")Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }
    @PutMapping("{id}")
    public void updateById(@PathVariable("id")Long id , @RequestBody HobbyRequest hobbyRequest){
        service.update(id,hobbyRequest);
    }


}

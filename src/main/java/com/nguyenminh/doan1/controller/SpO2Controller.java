package com.nguyenminh.doan1.controller;


import com.nguyenminh.doan1.dto.SpO2Request;
import com.nguyenminh.doan1.model.SpO2Model;
import com.nguyenminh.doan1.service.SpO2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/sp02")
@RequiredArgsConstructor
public class SpO2Controller {
    private final SpO2Service spO2Service;

    @GetMapping("/all")
    public List<SpO2Model> getAllSpO2(){
        return spO2Service.getAllSp02();
    }
    @PostMapping("/create")
    public void createSpO2 (@RequestBody SpO2Request spO2Request){
        spO2Service.createSpO2(spO2Request);
    }
    @GetMapping("/{userId}")
    public List<SpO2Model> getAllSpO2(@PathVariable String userId){
        return spO2Service.getSp02ById(userId);
    }

}

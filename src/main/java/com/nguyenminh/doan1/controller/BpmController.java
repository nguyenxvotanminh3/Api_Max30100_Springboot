package com.nguyenminh.doan1.controller;

import com.nguyenminh.doan1.dto.BpmRequest;
import com.nguyenminh.doan1.dto.SpO2Request;
import com.nguyenminh.doan1.model.BpmModel;
import com.nguyenminh.doan1.model.SpO2Model;
import com.nguyenminh.doan1.service.BpmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/v3/bpm")
public class BpmController {

    private final BpmService bpmService;
    @GetMapping("/all")
    public List<BpmModel> getAllBpm(){
        return bpmService.getAllBpm();
    }
    @PostMapping("/create/{userId}")
    public void createBpm (@RequestBody BpmRequest bpmRequest , @PathVariable String userId){
        bpmService.createBpm(bpmRequest,userId);
    }
    @GetMapping("/{userId}")
    public List<BpmModel> getBpmById(@PathVariable String userId){
        return bpmService.getBpmById(userId);
    }

}

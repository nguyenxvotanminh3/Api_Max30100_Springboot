package com.nguyenminh.doan1.service;

import com.nguyenminh.doan1.dto.SpO2Request;
import com.nguyenminh.doan1.model.SpO2Model;
import com.nguyenminh.doan1.model.UserModel;
import com.nguyenminh.doan1.repository.SpO2Repository;
import com.nguyenminh.doan1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpO2Service {
    //---------------------------------------------------------------//
    private final SpO2Repository spO2Repository;
    private final UserRepository userRepository;
    //---------------------------------------------------------------//
    public List<SpO2Model> getAllSp02 (){
        return spO2Repository.findAll();
    }

   public String createSpO2(SpO2Request spO2Request , String userId){

       Optional<UserModel> userModel = userRepository.findById(userId);
       float value = spO2Request.getValue();
       if (userModel.isPresent()) {
           SpO2Model spO2Model = SpO2Model.builder()
                   .value(spO2Request.getValue())
                   .createdAt(LocalDateTime.now())
                   .build();
           spO2Model.setUserId(userId);
           spO2Repository.save(spO2Model);
           //add sp02 to user

         userModel.ifPresent(userModel1 -> {
             List<Float> listSp02 = userModel.get().getSp02();
             listSp02.add(value);
             userRepository.save(userModel1);
         });


           return "spO2 of : "+ userModel.get().getUserName() +" found ";
       }
        else
            return "No user found";
   }

    public List<SpO2Model> getSp02ById(String userId) {
        List<SpO2Model> spO2Models = spO2Repository.findAll();

        List<SpO2Model> spO2ModelList = new ArrayList<>();
        spO2Models.forEach((sp02)->{

            if(sp02.getUserId().equals(userId)){
            spO2ModelList.add(sp02);}

        });

        return spO2ModelList;
    }
}

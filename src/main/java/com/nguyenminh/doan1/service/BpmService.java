package com.nguyenminh.doan1.service;

import com.nguyenminh.doan1.dto.BpmRequest;
import com.nguyenminh.doan1.model.BpmModel;
import com.nguyenminh.doan1.model.UserModel;
import com.nguyenminh.doan1.repository.BpmRepository;
import com.nguyenminh.doan1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BpmService {

    //-----------------------------------------------
    private final UserRepository userRepository;

    private final BpmRepository bpmRepository;
    //---------------------------------------------------
    public List<BpmModel> getAllBpm() {
        return bpmRepository.findAll();
    }


    public void createBpm(BpmRequest bpmRequest){
        List<UserModel> userModelList = userRepository.findAll();
        for(int i = 0 ; i < userModelList.size(); i++){
            if(userModelList.get(i).getStatus().equals("Login")){
                Optional<UserModel> userModel = userRepository.findById(userModelList.get(i).getUserId());
                float value = bpmRequest.getValue();
                BpmModel bpmModel = BpmModel.builder()
                        .value(bpmRequest.getValue())
                        .createdAt(LocalDateTime.now())
                        .build();
                bpmModel.setUserId(userModelList.get(i).getUserId());
                bpmRepository.save(bpmModel);
                //add sp02 to user
                userModel.ifPresent(userModel1 -> {
                    List<Float> listBpm = userModel.get().getBpm();
                    listBpm.add(value);
                    userRepository.save(userModel1);
                });

                System.out.println("spO2 of : "+ userModel.get().getUserName() +" found ");
            } else {
                System.out.println("No user login");
            }
        }


        }
    public List<BpmModel> getBpmById(String userId) {
        List<BpmModel> bpmModel = bpmRepository.findAll();

        List<BpmModel> bpmModelList = new ArrayList<>();
        bpmModel.forEach((bpm)->{

            if(bpm.getUserId().equals(userId)){
                bpmModelList.add(bpm);}

        });

        return bpmModelList;
    }

}

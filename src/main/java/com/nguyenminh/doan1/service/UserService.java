package com.nguyenminh.doan1.service;

import com.nguyenminh.doan1.dto.UserRequest;
import com.nguyenminh.doan1.dto.UserResponse;
import com.nguyenminh.doan1.model.UserModel;
import com.nguyenminh.doan1.repository.SpO2Repository;
import com.nguyenminh.doan1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  //------------------------------------------------------------------------//
  private  final UserRepository userRepository;
  private final SpO2Repository spO2Repository;
  //-------------------------------------------------------------------------//

  // Find all user
  public List<UserResponse> getAllUser() {
  List<UserModel> user = userRepository.findAll();
    return user.stream().map(this::mapToUserResponse).toList();

  }

  // Get User By Id
  public Optional<UserResponse> getUserById(String id) {
    // find all and put in products


    return userRepository.findById(id).map(this::mapToUserResponse);

  }

  private UserResponse mapToUserResponse(UserModel userModel) {

    return UserResponse.builder()
            .userId(userModel.getUserId())
            .bpm(userModel.getBpm())
            .userName(userModel.getUserName())
            .sp02(userModel.getSp02())

            .build();



  }
  public void creatUser(UserRequest userRequest){
    UserModel userModel = UserModel.builder()
            .userName(userRequest.getUserName())
            .build();
    if (userModel.getSp02() == null || userModel.getBpm() == null){
      userModel.setSp02(new ArrayList<>());
      userModel.setBpm(new ArrayList<>());
    }
    userRepository.save(userModel);

  }

  public void autoAjustUser(String userId){

  }
  public String deleteUser(String id){

    Optional<UserModel> userModel = userRepository.findById(id);
    if(userModel.isPresent()){
      userRepository.deleteById(id);
      return "Deleted user : " + id;
    } else
      return "Cant find user";
  }

}

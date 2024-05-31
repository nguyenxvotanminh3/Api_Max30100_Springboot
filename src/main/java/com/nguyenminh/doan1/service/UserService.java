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
            .status(userModel.getStatus())
            .sp02(userModel.getSp02())
            .build();
  }
  public void createUser(UserRequest userRequest){
    UserModel userModel = UserModel.builder()
            .userName(userRequest.getUserName())
            .status(userRequest.getStatus())
            .build();
    if (userModel.getSp02() == null || userModel.getBpm() == null || userModel.getStatus() == null){
      userModel.setSp02(new ArrayList<>());
      userModel.setBpm(new ArrayList<>());
      userModel.setStatus("Logout");
    }
             userModel.setRoles("User");
    userRepository.save(userModel);

  }
  public void deleteUser(String id){

    Optional<UserModel> userModel = userRepository.findById(id);
    if(userModel.isPresent()){
      userRepository.deleteById(id);
    }
  }
  public UserModel findByName(String name) {
    List<UserModel> userModelList = userRepository.findAll();
    UserModel userModel = new UserModel();
    for (int i = 0; i < userModelList.size(); i++) {
      System.out.print("This is user model: ");
      System.out.println(userModelList.get(i).getUserName());
      if (userModelList.get(i).getUserName().equals(name)) {
        System.out.print("UserFound : ");
        userModel = userModelList.get(i);
        System.out.print("User id : " + userModel.getUserId());
        break;
      }else if(i == userModelList.size() - 1){
        throw new RuntimeException("Cannot find user");
      }
    }
    return userModel;
  }


  public Optional<UserModel> updateUserStatus(UserRequest userRequest, String id) {
    Optional<UserModel> userModel = userRepository.findById(id);
    userModel.ifPresent(userModel1 -> {
      userModel1.setUserId(id);
      userModel1.setUserName(userRequest.getUserName());
      userModel1.setStatus(userRequest.getStatus());
      userRepository.save(userModel1);
    });
    return userModel;
  }
}

    package com.nguyenminh.doan1.controller;

    import com.nguyenminh.doan1.dto.UserRequest;
    import com.nguyenminh.doan1.dto.UserResponse;
    import com.nguyenminh.doan1.model.UserModel;
    import com.nguyenminh.doan1.service.UserService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/v1/user")
    @RequiredArgsConstructor
    @CrossOrigin
    public class UserController {
        private final UserService userService ;
        @GetMapping("/all")
        public List<UserResponse> getAllUser(){

           return userService.getAllUser() ;
        }

        @GetMapping("/{id}")
        public Optional<UserResponse> getUserById(@PathVariable String id){
            return userService.getUserById(id);
        }


        @PostMapping("/create")
        public void createUser(@RequestBody UserRequest userRequest) {
            userService.creatUser(userRequest);
        }
        @PutMapping("/update/{id}")
        public void updateUser(@RequestBody UserRequest userRequest , @PathVariable String id){

        }

        @DeleteMapping("/delete/{id}")
        @ResponseStatus(HttpStatus.OK)
        public void deleteUser(@PathVariable String id){
            userService.deleteUser(id);
        }
    }

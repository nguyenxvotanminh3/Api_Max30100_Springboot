    package com.nguyenminh.doan1.controller;

    import com.nguyenminh.doan1.dto.UserRequest;
    import com.nguyenminh.doan1.dto.UserResponse;
    import com.nguyenminh.doan1.model.UserModel;
    import com.nguyenminh.doan1.service.JwtService;
    import com.nguyenminh.doan1.service.UserService;
    import lombok.RequiredArgsConstructor;
    //    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/v1/user")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    public class UserController {
        //////////////////////////////////////////////////////////////////////////
        private final JwtService jwtService;
        private final UserService userService ;
        //////////////////////////////////////////////////////////////////////////
        @GetMapping("/all")
//        @PreAuthorize("hasAuthority('ROLE_USER')")
        public List<UserResponse> getAllUser(){

           return userService.getAllUser() ;
        }

        @GetMapping("/{id}")
        public Optional<UserResponse> getUserById(@PathVariable String id){
            return userService.getUserById(id);
        }


        @PostMapping("/create")
        public void createUser(@RequestBody UserRequest userRequest) {
            userService.createUser(userRequest);
        }
        @PutMapping("/{id}")
        public Optional<UserModel> updateUser(@RequestBody UserRequest userRequest , @PathVariable String id){
            return userService.updateUserStatus(userRequest,id);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable String id){
            userService.deleteUser(id);
        }


//        @PostMapping("/authenticate")
//        public String authenticateAndGetTokenReturn(@RequestBody AuthRequest authRequest){
//            return jwtService.generateToken(authRequest.getUserName());
//        }

        @GetMapping("/getbyname/{name}")
        public UserModel getUserIdByName(@PathVariable String name){
        return userService.findByName(name);
        }
    }

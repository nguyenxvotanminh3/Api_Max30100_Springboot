package com.nguyenminh.doan1.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    @Id
    private String userId ;
    private List<Float> bpm;
    private List<Float> sp02;
    private String name;
    private String userName ;
    private String logInName ;
    private String password ;
    private String roles;
    private String status;






}

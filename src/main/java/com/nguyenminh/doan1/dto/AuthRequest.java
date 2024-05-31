package com.nguyenminh.doan1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String userName;
    private String passWord;
}

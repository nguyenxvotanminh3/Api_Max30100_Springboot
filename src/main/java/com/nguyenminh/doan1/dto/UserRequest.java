package com.nguyenminh.doan1.dto;

import com.nguyenminh.doan1.model.BpmModel;
import com.nguyenminh.doan1.model.SpO2Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String userName ;


}

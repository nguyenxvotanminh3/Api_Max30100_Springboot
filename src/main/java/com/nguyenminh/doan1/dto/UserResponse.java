package com.nguyenminh.doan1.dto;

import com.nguyenminh.doan1.model.BpmModel;
import com.nguyenminh.doan1.model.SpO2Model;
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
public class UserResponse {
    @Id
    private String userId ;
    private List<Float> bpm;
    private List<Float> sp02;
    private String userName ;
}

package com.nguyenminh.doan1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "spo2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpO2Model {
    @Id
    private String spO2Id;
    private float value;
    private String userId;
    private LocalDateTime createdAt;

    //created at ( real time )
}

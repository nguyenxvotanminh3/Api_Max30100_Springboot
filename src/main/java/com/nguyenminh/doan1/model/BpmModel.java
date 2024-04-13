package com.nguyenminh.doan1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "bpm")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BpmModel {

    @Id
    private String bpmId;
    private float value;
    private LocalDateTime createdAt;
    String userId;
}

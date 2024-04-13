package com.nguyenminh.doan1.repository;

import com.nguyenminh.doan1.model.SpO2Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpO2Repository extends MongoRepository<SpO2Model, String> {
}

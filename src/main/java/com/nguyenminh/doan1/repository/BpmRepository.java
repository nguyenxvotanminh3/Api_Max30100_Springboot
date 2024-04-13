package com.nguyenminh.doan1.repository;

import com.nguyenminh.doan1.model.BpmModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BpmRepository extends MongoRepository<BpmModel, String> {
}

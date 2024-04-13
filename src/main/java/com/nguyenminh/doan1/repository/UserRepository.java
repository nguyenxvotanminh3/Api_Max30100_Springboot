package com.nguyenminh.doan1.repository;

import com.nguyenminh.doan1.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}

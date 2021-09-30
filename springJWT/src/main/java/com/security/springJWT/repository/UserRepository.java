package com.security.springJWT.repository;

import com.security.springJWT.user.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserData, String> {

    public UserData findByUserName(String userName);

}

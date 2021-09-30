package com.security.springJWT.repository;

import com.security.springJWT.user.TokenData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<TokenData,String> {

    public TokenData findByUserName(String userName);

}

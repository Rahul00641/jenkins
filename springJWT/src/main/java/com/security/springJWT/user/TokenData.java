package com.security.springJWT.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tokenData")
public class TokenData {

    @Id
    String id;
    String userName,token;
    Date expirationTime;

    public TokenData() {
    }

    public TokenData(String userName, String token, Date expirationTime) {
        this.userName = userName;
        this.token = token;
        this.expirationTime = expirationTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
}

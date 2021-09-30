package com.security.springJWT.user;

public class AuthenticationRequest {

    private String userName;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(AuthenticationRequest req) {
        this.userName = req.userName;
        this.password = req.password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package com.security.springJWT.controller;

import com.security.springJWT.services.UserDataService;
import com.security.springJWT.user.AuthenticationRequest;
import com.security.springJWT.user.UserData;
import com.security.springJWT.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello User";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
    }
    catch (Exception e){
        throw new Exception("Invalid Credentials");
    }
    String token =  jwtUtil.generateToken(authRequest.getUserName());
    userDataService.storeTokenData(authRequest.getUserName(),token,jwtUtil.extractExpiration(token));
    return "Authenticated  "+token;
    }

//    @RequestMapping(value = "/token/getall")
//    public List<TokenData> getall(){
//        return userDataService.getall();
//    }
//
//    @RequestMapping(value = "/token/deleteall")
//    public String deleteAll(){
//        userDataService.deleteall();
//        return "deleted";
//    }

//    @RequestMapping(value = "/token/{userName}")
//    public String getToken(@PathVariable("userName") String userName){
//        return userDataService.getToken(userName);
//    }

    @RequestMapping(method = RequestMethod.POST,value = "/signup")
    public String signUp(@RequestBody UserData user) {
        userDataService.signUp(user);
        return "User Added";
    }

    @RequestMapping("/getall")
    public List<UserData> getAll(){
        return userDataService.getAll();
    }

}

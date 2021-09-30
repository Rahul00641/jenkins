package com.security.springJWT.services;

import com.security.springJWT.repository.TokenRepository;
import com.security.springJWT.repository.UserRepository;
import com.security.springJWT.user.TokenData;
import com.security.springJWT.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDataService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserData user = userRepository.findByUserName(userName);
        return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
    }

    public void storeTokenData(String userName, String token, Date expirationTime){
        delete(userName);
        TokenData tD = new TokenData(userName,token,expirationTime);
        tokenRepository.save(tD);
    }

//    public void deleteall(){
//        tokenRepository.deleteAll();
//    }
//
//    public String getToken(String userName){
//        return tokenRepository.findByUserName(userName).getToken();
//    }

    public void delete(String userName){
        TokenData tokenData = tokenRepository.findByUserName(userName);
        if(tokenData == null){
            return;
        }
        else
        {
            tokenRepository.delete(tokenData);
        }
    }

//    public List<TokenData> getall(){
//        return tokenRepository.findAll();
//    }

    public List<UserData> getAll(){
        return userRepository.findAll();
    }

    public void signUp(UserData user){
        userRepository.save(user);
    }
}

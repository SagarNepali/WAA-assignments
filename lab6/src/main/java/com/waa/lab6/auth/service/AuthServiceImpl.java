package com.waa.lab6.auth.service;

import com.waa.lab6.auth.domain.LoginRequest;
import com.waa.lab6.auth.domain.LoginResponse;
import com.waa.lab6.security.utils.jwt.JwtTokenManager;
import com.waa.lab6.security.utils.jwt.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements  AuthService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());
        String accessToken = jwtTokenManager.generateJwtToken(userDetails);
//        String refreshToken = jwtTokenManager.generateRefreshToken(loginRequest.getEmail());
        LoginResponse newResponse = new LoginResponse(accessToken);
        return newResponse;
    }
}

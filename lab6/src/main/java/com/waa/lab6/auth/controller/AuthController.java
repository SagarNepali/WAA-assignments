package com.waa.lab6.auth.controller;

import com.waa.lab6.auth.domain.LoginRequest;
import com.waa.lab6.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }
}

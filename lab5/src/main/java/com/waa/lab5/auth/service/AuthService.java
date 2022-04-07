package com.waa.lab5.auth.service;

import com.waa.lab5.auth.domain.LoginRequest;
import com.waa.lab5.auth.domain.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}

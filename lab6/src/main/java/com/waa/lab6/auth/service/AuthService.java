package com.waa.lab6.auth.service;

import com.waa.lab6.auth.domain.LoginRequest;
import com.waa.lab6.auth.domain.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}

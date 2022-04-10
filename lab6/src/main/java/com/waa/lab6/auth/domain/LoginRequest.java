package com.waa.lab6.auth.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String userName;
    private String password;
}

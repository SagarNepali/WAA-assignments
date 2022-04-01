package com.waa.lab2.user.service;

import com.waa.lab2.user.domain.User;
import com.waa.lab2.user.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();
    UserDto getById(Long id);
    void save(UserDto user);
    void update(Long id,UserDto user);
    void delete(Long id);
    List<UserDto> findAllByIdAndPostsGreaterThan(Long id,int val);
}

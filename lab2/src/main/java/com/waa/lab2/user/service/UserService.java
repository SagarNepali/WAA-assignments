package com.waa.lab2.user.service;

import com.waa.lab2.post.domain.Post;
import com.waa.lab2.user.domain.User;
import com.waa.lab2.user.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();
    UserDto getById(Long id);
    void save(User user);
    void update(Long id,UserDto user);
    void delete(Long id);
    List<Post> findAllPostsByUserId(Long id);
    List<UserDto> findAllUsersHavingPostsGreaterThan(int val);

}

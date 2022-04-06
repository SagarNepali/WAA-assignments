package com.waa.lab5.user.service;

import com.waa.lab5.comment.domain.Comment;
import com.waa.lab5.exception.domain.DataNotFoundException;
import com.waa.lab5.post.domain.Post;
import com.waa.lab5.user.domain.User;
import com.waa.lab5.user.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getById(Long id) throws DataNotFoundException;
    void save(User user);
    void update(Long id,UserDto user);
    void delete(Long id);
    List<Post> findAllPostsByUserId(Long id);
    List<UserDto> findAllUsersHavingPostsGreaterThan(int val);
    Comment findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);
}

package com.waa.lab3.user.service;

import com.waa.lab3.comment.domain.Comment;
import com.waa.lab3.post.domain.Post;
import com.waa.lab3.user.domain.User;
import com.waa.lab3.user.domain.dto.UserDto;
import com.waa.lab3.user.domain.dto.UserPostCommentDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getById(Long id);
    void save(User user);
    void update(Long id,UserDto user);
    void delete(Long id);
    List<Post> findAllPostsByUserId(Long id);
    List<UserDto> findAllUsersHavingPostsGreaterThan(int val);
    Comment findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);
}

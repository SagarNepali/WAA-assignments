package com.waa.lab3.user.service;

import com.waa.lab3.comment.domain.Comment;
import com.waa.lab3.post.domain.Post;
import com.waa.lab3.user.domain.User;
import com.waa.lab3.user.domain.dto.UserDto;
import com.waa.lab3.user.domain.dto.UserPostCommentDto;
import com.waa.lab3.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        return modelMapper.map(userRepository.findById(id).orElse(null),UserDto.class);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserDto user) {
        userRepository.save(modelMapper.map(user,User.class));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAllUsersHavingPostsGreaterThan(int val) {
        return userRepository.findAllUsersHavingPostsGreaterThan(val)
                .stream()
                .map(users -> modelMapper.map(users,UserDto.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public UserPostCommentDto findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId) {
//        return modelMapper.map(userRepository.findByUserIdAndPostIdAndCommentId(userId,postId,commentId),UserPostCommentDto.class);
//    }

    @Override
    public Comment findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId) {
        return userRepository.findByUserIdAndPostIdAndCommentId(userId,postId,commentId);
    }

    @Override
    public List<Post> findAllPostsByUserId(Long id) {
        return userRepository.findById(id).get().getPosts();
    }

}

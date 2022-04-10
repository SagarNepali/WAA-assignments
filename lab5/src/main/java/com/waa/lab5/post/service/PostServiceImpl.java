package com.waa.lab5.post.service;

import com.waa.lab5.post.domain.Post;
import com.waa.lab5.post.domain.PostV2;
import com.waa.lab5.post.repository.PostRepository;
import com.waa.lab5.security.utils.jwt.service.JwtUserDetailsService;
import com.waa.lab5.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    private UserService userService;


    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post p,String userName) {

        p.setUser(userService.findByUserName(userName));
        postRepository.save(p);
    }

    @Override
    public void update(long id,Post p) {
        Post dto = getById(id);
        p.setId(dto.getId());
        if(Optional.of(dto).isPresent()) {
            postRepository.save(p);
        }

    }

    @Override
    public void delete(long id) {
        Post post = getById(id);
        if(Optional.of(post).isPresent()) {
            postRepository.delete(post);
        }
    }

    @Override
    public Post getById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public List<PostV2> fetchAllDto() {
        return getAll()
                .stream()
                .map(p -> modelMapper.map(p, PostV2.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<PostV2> filterByAuthorDto(String query) {
        return filterByAuthor(query.toLowerCase())
                .stream()
                .map(p -> modelMapper.map(p,PostV2.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> filterByAuthor(String query) {
        return postRepository.findAllByAuthorIgnoreCase(query);
    }

    @Override
    public List<PostV2> filterByTitleDto(String query) {
        return filterByTitle(query)
                .stream()
                .map(p -> modelMapper.map(p,PostV2.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> filterByTitle(String query) {
        return postRepository.findAllByTitleIgnoreCase(query);
    }
}

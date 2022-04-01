package com.waa.lab1.service;

import com.waa.lab1.domain.Post;
import com.waa.lab1.domain.PostV2;
import com.waa.lab1.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post p) {
        postRepository.save(p);
    }

    @Override
    public void update(long id,Post p) {
        Post dto = getById(id);
        p.setId(dto.getId());
        if(Optional.of(dto).isPresent()) {
            postRepository.update(p);
        }

    }

    @Override
    public void delete(long id) {
        Post dto = getById(id);
        if(Optional.of(dto).isPresent()) {
            postRepository.delete(id);
        }
    }

    @Override
    public Post getById(long id) {
        return postRepository.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
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
        return postRepository.getAll()
                .stream()
                .filter(post -> post.getAuthor().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}

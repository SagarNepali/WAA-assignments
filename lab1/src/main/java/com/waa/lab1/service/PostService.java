package com.waa.lab1.service;

import com.waa.lab1.domain.Post;
import com.waa.lab1.domain.PostV2;

import java.util.List;

public interface PostService {

    void save(Post p);
    void update(long id,Post p);
    void delete(long id);
    Post getById(long id);
    List<Post> getAll();

    List<PostV2> fetchAllDto();

    List<PostV2> filterByAuthorDto(String query);
    List<Post> filterByAuthor(String query);
}

package com.waa.lab5.post.service;

import com.waa.lab5.post.domain.Post;
import com.waa.lab5.post.domain.PostV2;

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

    List<PostV2> filterByTitleDto(String query);

    List<Post> filterByTitle(String query);
}

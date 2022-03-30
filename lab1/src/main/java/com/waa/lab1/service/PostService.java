package com.waa.lab1.service;

import com.waa.lab1.domain.Post;

import java.util.List;

public interface PostService {

    void save(Post p);
    void update(long id,Post p);
    void delete(long id);
    Post getById(long id);
    List<Post> getAll();
}

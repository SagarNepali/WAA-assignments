package com.waa.lab2.post.repository;

import com.waa.lab2.post.domain.Post;

import java.util.List;

public interface PostRepository {

    void save(Post p);
    void update(Post P);
    void delete(long id);
    Post getById(long id);
    List<Post> getAll();
}

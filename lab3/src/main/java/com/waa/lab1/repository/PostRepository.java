package com.waa.lab1.repository;

import com.waa.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository {

    void save(Post p);
    void update(Post P);
    void delete(long id);
    Post getById(long id);
    List<Post> getAll();
}

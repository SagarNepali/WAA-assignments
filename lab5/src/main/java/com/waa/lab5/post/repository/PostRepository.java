package com.waa.lab5.post.repository;

import com.waa.lab5.post.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {

    List<Post> findAll();

    List<Post> findAllByTitleIgnoreCase(String title);

    List<Post> findAllByAuthorIgnoreCase(String author);
}

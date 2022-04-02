package com.waa.lab4.comment.repository;

import com.waa.lab4.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findAll();
}

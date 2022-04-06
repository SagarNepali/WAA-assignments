package com.waa.lab5.comment.service;

import com.waa.lab5.comment.domain.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);
    List<Comment> findAll();
    Comment findById(Long id);
}

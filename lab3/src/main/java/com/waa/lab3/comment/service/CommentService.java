package com.waa.lab3.comment.service;

import com.waa.lab3.comment.domain.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);
    List<Comment> findAll();
    Comment findById(Long id);
}

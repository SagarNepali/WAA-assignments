package com.waa.lab5.comment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waa.lab5.post.domain.Post;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JsonBackReference
    private Post post;
}

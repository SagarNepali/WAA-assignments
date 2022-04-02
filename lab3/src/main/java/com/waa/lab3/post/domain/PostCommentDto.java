package com.waa.lab3.post.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waa.lab3.comment.domain.dto.CommentDto;
import lombok.Data;

@Data
public class PostCommentDto {

    private Long id;
    private String author;
    private String title;
    private String content;
    @JsonProperty("comments")
    private CommentDto commentDto;
}

package com.waa.lab3.user.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waa.lab3.post.domain.PostCommentDto;
import lombok.Data;

@Data
public class UserPostCommentDto {
    private Long id;
    private String name;
    @JsonProperty("posts")
    private PostCommentDto postCommentDto;
}

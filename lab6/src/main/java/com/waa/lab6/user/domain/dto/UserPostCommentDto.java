package com.waa.lab6.user.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waa.lab6.post.domain.PostCommentDto;
import lombok.Data;

@Data
public class UserPostCommentDto {
    private Long id;
    private String name;
    @JsonProperty("posts")
    private PostCommentDto postCommentDto;
}

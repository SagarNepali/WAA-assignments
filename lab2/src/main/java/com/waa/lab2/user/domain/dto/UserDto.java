package com.waa.lab2.user.domain.dto;

import com.waa.lab2.post.domain.Post;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
public class UserDto {


    private long id;;
    private String name;
}

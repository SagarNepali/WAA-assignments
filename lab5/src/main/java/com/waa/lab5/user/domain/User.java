package com.waa.lab5.user.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.waa.lab5.post.domain.Post;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Post> posts;
}

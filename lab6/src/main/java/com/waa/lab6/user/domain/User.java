package com.waa.lab6.user.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.waa.lab6.post.domain.Post;
import com.waa.lab6.userRole.domain.Role;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable
//    @JsonManagedReference
    private List<Role> roles;
}

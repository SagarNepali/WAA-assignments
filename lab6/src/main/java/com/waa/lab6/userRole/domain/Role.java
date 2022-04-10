package com.waa.lab6.userRole.domain;

import com.waa.lab6.user.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
//    @JsonBackReference
    private List<User> users;


}

package com.waa.lab5.userRole.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waa.lab5.user.domain.User;
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

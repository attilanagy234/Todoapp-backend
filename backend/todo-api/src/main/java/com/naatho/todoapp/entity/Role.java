package com.naatho.todoapp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Role {

    public static final String USER_ROLE = "USER";
    public static final String ADMIN_ROLE = "ADMIN";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @NotBlank
    private String name;

    @ManyToMany(mappedBy = "roles", fetch=FetchType.LAZY)
    private List<User> users;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<Privilege> privileges = new ArrayList<>();

    public Role(String name) {
        this.name = name;

    }
}

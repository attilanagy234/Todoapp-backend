package com.naatho.todoapp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDetailsImpl implements UserDetails {

    private User user;

    private static final String defaultRolePrefix = "ROLE_";

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<? extends GrantedAuthority> wtf =  Stream.concat(
                user.getRoles().stream()
                        .map(Role::getName)
                        .map(s -> defaultRolePrefix + s),

                user.getRoles().stream()
                        .flatMap(role -> role.getPrivileges().stream())
                        .map(Privilege::getName))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        System.out.println(wtf);
        return wtf;

    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
        //TODO: fix this
        //return user.getActive();
    }
}

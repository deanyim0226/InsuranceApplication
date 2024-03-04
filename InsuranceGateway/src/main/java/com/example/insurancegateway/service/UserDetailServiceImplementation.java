package com.example.insurancegateway.service;


import com.example.insurancegateway.domain.Role;
import com.example.insurancegateway.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class UserDetailServiceImplementation implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User retrievedUser = userService.findUserByName(username);

        if(retrievedUser == null){
            throw new UsernameNotFoundException(username);
        }

        List<Role> roles = retrievedUser.getRoles();

        Collection<GrantedAuthority> grantedAuthority = new HashSet<>();

        for(Role role : roles){
            grantedAuthority.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(retrievedUser.getUsername(), retrievedUser.getPassword(), grantedAuthority);
    }
}

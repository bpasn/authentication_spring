package com.spirngauth.authentication_spring.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spirngauth.authentication_spring.models.UserModel;
import com.spirngauth.authentication_spring.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException{
        UserModel user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not found with username: "+ username));
        return UserDetailsImpl.build(user);
    }
}

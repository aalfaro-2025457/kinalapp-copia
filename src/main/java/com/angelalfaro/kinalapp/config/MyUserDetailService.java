package com.angelalfaro.kinalapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.angelalfaro.kinalapp.entity.User;
import com.angelalfaro.kinalapp.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException{
        User u = userRepository.findByUsernameUser(user)
            .orElseThrow(() -> new UsernameNotFoundException("User not found:" + user));

            return org.springframework.security.core.userdetails.User.builder()
                .username(u.getUsernameUser())
                .password(u.getPasswordUser())
                .roles(u.getRolUser())
                .disabled(u.getStateUser() == 0)
                .build();
    }
    
}

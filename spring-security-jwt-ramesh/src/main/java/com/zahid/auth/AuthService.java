package com.zahid.auth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zahid.users.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // for our case userName is an unique email
        log.info("userName: {}", email);
        String email2 = userRepository.findByEmail(email).getEmail();
        String password = userRepository.findByEmail(email).getPassword();
        log.info("email: {}", email2);
        log.info("password: {}", password);

        return new User(email2, password, new ArrayList<>());
    }

    
}

package com.zahid.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zahid.utils.JwtUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        log.info("request body: {}", authRequest);
        log.info("email: {}", authRequest.getEmail());
        log.info("password: {}", authRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));           
        } catch (Exception e) {
            throw new Exception("Invalid Email or Password");
        }

        return jwtUtil.generateToken(authRequest.getEmail());
    }
}

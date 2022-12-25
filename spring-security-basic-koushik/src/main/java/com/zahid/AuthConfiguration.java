package com.zahid;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Deprecated
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {

    // for authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // setting your own configuration on auth object
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("123")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("123")
            .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // for authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/user").hasAnyRole("USER", "ADMIN")
            .antMatchers("/").permitAll()
            .and()
            .formLogin();
    }
}

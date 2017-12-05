package com.unitri.ppi.v2.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CsrfTokenRepository csrfTokenRepository () {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");

        return repository;
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //.csrf()
                //.csrfTokenRepository( csrfTokenRepository() )
                .httpBasic();
    }

    @Override
    public void configure (AuthenticationManagerBuilder builder) throws Exception {

        builder
                .inMemoryAuthentication()
                .withUser("thomaz").password("123")
                .roles("ADMIN", "DBA")
                .and()
                .withUser("andrey").password("123")
                .roles("ADMIN", "DBA");
    }
}
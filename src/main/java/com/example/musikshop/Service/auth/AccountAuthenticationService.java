package com.example.musikshop.Service.auth;

import com.example.musikshop.Entity.Customer;
import com.example.login.repositoryLogin.UserRepository;
import com.example.musikshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AccountAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    public Customer getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            System.out.println(authentication.getName());
            return customerRepository.findByEmail(authentication.getName()).orElse(null);
        }else{
            return null;
        }
    }

    public void login(String email,String password){
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(
                        userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(userToken);
        if(userToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(userToken);
        }

    }
}

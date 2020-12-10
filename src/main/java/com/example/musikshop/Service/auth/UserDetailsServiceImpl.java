package com.example.musikshop.Service.auth;

import com.example.musikshop.Entity.Customer;
import com.example.musikshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email){
        Optional<Customer> userOptional = customerRepository.findbyEmail(email);
        Customer customer = userOptional.get();
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("Default"));
        return new org.springframework.security.core.userdetails.User(customer.getEmail(),customer.getPassword(),authorityList);
    }

}

package com.example.musikshop.Service;

import com.example.musikshop.Entity.Customer;
import com.example.musikshop.Service.auth.AccountAuthenticationService;
import com.example.musikshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService implements CustomerServiceIF{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AccountAuthenticationService authenticationService;

    @Override
    public void createUser(Customer customer){
        String password = customer.getPassword();
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    @Override
    public Customer login(String username,String password){
        Customer customer = this.findByUsername(username);
        if(customer!=null){
            if(BCrypt.checkpw(password,customer.getPassword()));
            return customer;
        }
        return null;
    }

    @Override
    public Customer findByUsername(String username){
        Iterable<Customer> userList = customerRepository.findAll();
        for(Customer customer :userList){
            if(customer.getEmail()==username){
                return customer;
            }
        }
        return null;
    }

    @Transactional
    public void registerNewUser(Customer customer){
        System.out.println("i am here");
        String password = customer.getPassword();
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        Customer persistedUser = customerRepository.save(customer);
        if(persistedUser!= null){
            authenticationService.login(customer.getEmail(),password);
        }
    }
}

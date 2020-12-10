package com.example.musikshop.Service;

import com.example.musikshop.Entity.Customer;

public interface CustomerServiceIF {
    public void createUser(Customer customer);
    public Customer login(String username,String password);
    public Customer findByUsername(String username);
    public void registerNewUser(Customer customer);
}

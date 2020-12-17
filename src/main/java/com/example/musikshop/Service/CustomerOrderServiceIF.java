package com.example.musikshop.Service;

import com.example.musikshop.Entity.CustomerOrder;

public interface CustomerOrderServiceIF {
    public void createOrder(CustomerOrder customerOrder);
    public CustomerOrder findOrderbyId(long id);
}

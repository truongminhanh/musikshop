package com.example.musikshop.Service;

import com.example.musikshop.Entity.CustomerOrder;
import com.example.musikshop.repository.CustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService implements CustomerOrderServiceIF{
    CustomerOrderRepository customerOrderRepository;

    @Override
    public void createOrder(CustomerOrder customerOrder){
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder findOrderbyId(long id){
        return customerOrderRepository.findById(id).get();
    }
}

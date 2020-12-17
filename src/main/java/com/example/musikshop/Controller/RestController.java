package com.example.musikshop.Controller;

import com.example.musikshop.Entity.CustomerOrder;
import com.example.musikshop.Service.CustomerOrderServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    CustomerOrderServiceIF customerOrderServiceIF;

    @RequestMapping(value="/getOrderStatus/{id}/{status}",method = RequestMethod.GET)
    public CustomerOrder getOrderStatus(@PathVariable("id") long id,@PathVariable("status")String status){
        CustomerOrder customerOrder = customerOrderServiceIF.findOrderbyId(id);
        customerOrder.setStatus(status);
        customerOrderServiceIF.createOrder(customerOrder);
        return customerOrder;
    }
}

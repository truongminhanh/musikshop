package com.example.musikshop.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class CustomerOrder {
    @Id
    private long id;

    private ArrayList<CartItem> items;

    private double total;
    private Customer customer;
    private String status;

    public CustomerOrder(long id,ArrayList<CartItem> items,double total,Customer customer, String status){
        this.status=status;
        this.items=items;
        this.id=id;
        this.total=total;
        this.customer=customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

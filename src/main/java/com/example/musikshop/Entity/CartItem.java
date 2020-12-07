package com.example.musikshop.Entity;

import java.util.Optional;

public class CartItem {

    private Optional<Musik> musik;
    private int quantity;

    public CartItem(Optional<Musik> musik){
        this.musik=musik;
    }

    public Optional<Musik> getMusik(){
        return musik;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}

package com.example.musikshop.Entity;

import java.util.Optional;

public class CartItem {

    private Musik musik;
    private int quantity;
    private long cartMusikId;

    public CartItem(Musik musik,int quantity){
        this.quantity=quantity;
        this.musik=musik;
        this.cartMusikId=musik.getMusikId();
    }

    public long getCartMusikId(){
        return cartMusikId;
    }

    public void setCartMusikId(long cartMusikId) { this.cartMusikId = cartMusikId;}

    public String getQuantityString(){
        return String.valueOf(quantity);
    }

    public void setMusik(Musik musik) {
        this.musik = musik;
    }

    public Musik getMusik(){
        return musik;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}

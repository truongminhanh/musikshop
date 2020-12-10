package com.example.musikshop.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserOrder {
    @Id
    private long userOrderId;
}

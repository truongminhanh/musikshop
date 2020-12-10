package com.example.musikshop.HomeScreenController;

import com.example.musikshop.Entity.UserOrder;
import org.springframework.data.repository.CrudRepository;

public interface UserOrderRepository extends CrudRepository<UserOrder,Long> {
}

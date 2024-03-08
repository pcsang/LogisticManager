package com.express.repository;

import com.express.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

//    @Query("SELECT e  FROM orders e WHERE e.name_order LIKE ?1")
    Order findByNameOrder(String name);
}

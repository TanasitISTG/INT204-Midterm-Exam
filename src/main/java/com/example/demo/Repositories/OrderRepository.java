package com.example.demo.Repositories;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    void deleteAllByCustomerObject(Customer customer);
}

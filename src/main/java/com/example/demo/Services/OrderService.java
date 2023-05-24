package com.example.demo.Services;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.Order;
import com.example.demo.Repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;

    public void init() {
        List<Customer> customers = customerService.findAll();
        Order order1 = new Order();
        order1.setOrderNumber(1);
        order1.setOrderDate("2020-01-01");
        order1.setStatus("Shipped");
        order1.setCustomerObject(customers.get(0));
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setOrderNumber(2);
        order2.setOrderDate("2020-01-02");
        order2.setStatus("Shipped");
        order2.setCustomerObject(customers.get(1));
        orderRepository.save(order2);

        Order order3 = new Order();
        order3.setOrderNumber(3);
        order3.setOrderDate("2020-01-03");
        order3.setStatus("Shipped");
        order3.setCustomerObject(customers.get(2));
        orderRepository.save(order3);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Page<Order> getOrdersPage(Integer page, Integer size) {
        return orderRepository.findAll(PageRequest.of(page, size));
    }

    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order, Integer customerNumber) {
        Customer customer = customerService.findById(customerNumber);

        if (customer != null) {
            order.setCustomerObject(customer);
            return orderRepository.save(order);
        }

        return null;
    }

    public Order updateOrder(Integer orderNumber, Order order) {
        Order existOrder = findById(orderNumber);

        if (existOrder == null) {
            return null;
        }

        if (order.getOrderDate() != null) {
            existOrder.setOrderDate(order.getOrderDate());
        }

        if (order.getRequiredDate() != null) {
            existOrder.setRequiredDate(order.getRequiredDate());
        }

        if (order.getShippedDate() != null) {
            existOrder.setShippedDate(order.getShippedDate());
        }

        if (order.getStatus() != null) {
            existOrder.setStatus(order.getStatus());
        }

        if (order.getComments() != null) {
            existOrder.setComments(order.getComments());
        }

        if (order.getCustomerObject() != null) {
            existOrder.setCustomerObject(order.getCustomerObject());
        }
        return orderRepository.saveAndFlush(existOrder);
    }

    @Transactional
    public void deleteAllByCustomerNumber(Integer customerNumber) {
        Customer customer = customerService.findById(customerNumber);

        if (customer != null) {
            orderRepository.deleteAllByCustomerObject(customer);
        }
    }
}

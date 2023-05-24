package com.example.demo.Controllers;

import com.example.demo.DTOs.OrderDTO;
import com.example.demo.Entities.Order;
import com.example.demo.Services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/64130500034/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/init")
    public void init() {
        orderService.init();
    }

    @GetMapping("/page")
    public Page<OrderDTO> findAll(@RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size) {
        Page<Order> orders = orderService.getOrdersPage(page, size);
        Page<OrderDTO> orderDTOs = orders.map(order -> modelMapper.map(order, OrderDTO.class));
        return orderDTOs;
    }

    @GetMapping("")
    public List<OrderDTO> findAll() {
        List<Order> orders = orderService.findAll();
        List<OrderDTO> orderDTOs = orders.stream().map(order -> modelMapper.map(order, OrderDTO.class)).toList();
        return orderDTOs;
    }

    @PostMapping("")
    public Order saveOrder(@RequestBody Order order, @RequestParam Integer customerNumber) {
        return orderService.saveOrder(order, customerNumber);
    }

    @PutMapping("/{orderNumber}")
    public Order updateOrder(@PathVariable Integer orderNumber, @RequestBody Order order) {
        return orderService.updateOrder(orderNumber, order);
    }

    @DeleteMapping("/{customerNumber}")
    public void deleteAllByCustomerNumber(@PathVariable Integer customerNumber) {
        orderService.deleteAllByCustomerNumber(customerNumber);
    }
}

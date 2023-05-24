package com.example.demo.Services;

import com.example.demo.Entities.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void init() {
        Customer customer1 = new Customer();
        customer1.setCustomerNumber(1);
        customer1.setContactFirstName("Customer 1");
        customer1.setContactLastName("God");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(2);
        customer2.setContactFirstName("Customer 2");
        customer2.setContactLastName("God");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setCustomerNumber(3);
        customer3.setContactFirstName("Customer 3");
        customer3.setContactLastName("God");
        customerRepository.save(customer3);
    }
}

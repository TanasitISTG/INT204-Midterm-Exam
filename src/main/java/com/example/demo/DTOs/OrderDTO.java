package com.example.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer orderNumber;
    private String orderDate;
    private String status;

    @JsonIgnore
    private CustomerDTO customerObject;

    public String getCustomer() {
        return customerObject == null ? "" : customerObject.getInformation();
    }
}

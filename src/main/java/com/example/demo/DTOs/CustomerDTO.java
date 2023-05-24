package com.example.demo.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Integer customerNumber;
    private String contactFirstName;
    private String contactLastName;

    public String getInformation() {
        return customerNumber + "-" + contactFirstName + " " + contactLastName;
    }
}

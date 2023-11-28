package com.example.demoapi.service;

import com.example.demoapi.dto.request.CustomerRequest;
import com.example.demoapi.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public Page<Customer> getAll(CustomerRequest customerRequest, Pageable pageable);

}

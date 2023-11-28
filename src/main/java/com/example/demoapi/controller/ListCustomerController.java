package com.example.demoapi.controller;

import com.example.demoapi.dto.CustomerDTO;
import com.example.demoapi.dto.request.CustomerRequest;
import com.example.demoapi.dto.response.CustomerResponse;
import com.example.demoapi.entity.Customer;
import com.example.demoapi.service.CustomerService;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ListCustomerController {
//    private JMapper<CustomerDTO, Customer> mapper = new JMapper<>(CustomerDTO.class, Customer.class);
    private CustomerService customerService;

    @Autowired
    public ListCustomerController(CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @PostMapping("/get-list")
    public CustomerResponse advanceSearch(@Valid @RequestBody CustomerRequest customerRequest){
        Integer page = customerRequest.getPage();
        Integer size = customerRequest.getSize();
        String sortRequest = customerRequest.getSort();
        Sort sort = Sort.by(Sort.Direction.fromString(sortRequest),customerRequest.getOrder());
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Customer> customerPage = customerService.getAll(customerRequest,pageable);
        List<Customer> customers = customerPage.getContent();

// Lấy thông tin trang hiện tại và kích thước trang
        int currentPage = customerPage.getNumber();
        int pageSize = customerPage.getSize();
        long totalElement = customerPage.getTotalElements();

// Tạo đối tượng CustomerResponseDTO từ dữ liệu lấy được
        CustomerResponse responseDTO = new CustomerResponse(customers, currentPage, pageSize,totalElement);
        return responseDTO;
    }


}

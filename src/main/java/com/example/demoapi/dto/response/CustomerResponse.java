package com.example.demoapi.dto.response;
import java.util.ArrayList;
import java.util.List;

import com.example.demoapi.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse<D,S> {
    private List<Customer> content;
    private int page;
    private int size;
    private long total;

    public CustomerResponse(List<Customer> content, int page, int size,long total) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.total = total;
    }
}


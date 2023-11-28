package com.example.demoapi.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerRequest {
    public String name;
    public String age;
    public String address;
    public Integer page;
    public Integer size;
    public String sort;
    public String order;
}

package com.example.demoapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerDTO {
    public String id;
    public String name;
    public String age;
    public String address;
}

package com.example.demoapi.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String age;
    private String address;
}

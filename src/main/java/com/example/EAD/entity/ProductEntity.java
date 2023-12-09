package com.example.EAD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdID")
    private int id;

    @Column(name = "ProdName")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "DateOfManf")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfManf;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SaleEntity> saleEntities;
}

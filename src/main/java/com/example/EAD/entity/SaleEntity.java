package com.example.EAD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Sale")
@NoArgsConstructor
@AllArgsConstructor
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesmanID")
    private int id;

    @Column(name = "SlNo")
    private String slNo;

    @Column(name = "SalesmanName")
    private String name;

    @Column(name = "dos")
    private String dos;

    @Column(name = "ProdID")
    private int prodId;

    @ManyToOne() //EAGER
    @JoinColumn(name = "ProdID", insertable = false, updatable = false)
    private ProductEntity product;
}

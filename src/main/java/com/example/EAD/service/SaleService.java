package com.example.EAD.service;

import com.example.EAD.entity.SaleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    SaleEntity createSale(SaleEntity saleEntity);
    SaleEntity updateSale(SaleEntity saleEntity);
    void deleteSale(Long id);
    List<SaleEntity> getAllCategory();
    SaleEntity getSaleByID(Long id);
    List<SaleEntity> getCategoryByName(String name);
    Page<SaleEntity> findPaginated(Pageable pageable);
}

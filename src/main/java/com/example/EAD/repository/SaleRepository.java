package com.example.EAD.repository;

import com.example.EAD.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity,Long> {
    List<SaleEntity> findAllByName(String name);

    @Query("select c from SaleEntity c where c.name like %:name%")
    List<SaleEntity> findNameCustom(String name);
}

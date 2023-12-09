package com.example.EAD.repository;

import com.example.EAD.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByName(String name);

    @Query("select p from ProductEntity p where p.name like %:name%")
    List<ProductEntity> findNameCustom(String name);
}

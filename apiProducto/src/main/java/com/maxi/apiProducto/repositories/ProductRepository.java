package com.maxi.apiProducto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.apiProducto.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findByName(String name);
    
}

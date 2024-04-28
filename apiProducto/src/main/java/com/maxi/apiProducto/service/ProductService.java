package com.maxi.apiProducto.service;

import java.util.List;

import com.maxi.apiProducto.models.Product;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> findAllProducts();

    Product findProductById(Long id);

    void deleteProductById(Long id);

    Product updateProduct(Long id, Product product);
}

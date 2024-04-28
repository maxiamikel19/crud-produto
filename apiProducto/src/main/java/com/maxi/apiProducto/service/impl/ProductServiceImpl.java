package com.maxi.apiProducto.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maxi.apiProducto.exceptions.EntityDuplicatedNameCreationException;
import com.maxi.apiProducto.exceptions.EntityFindByIdNotFoundException;
import com.maxi.apiProducto.models.Product;
import com.maxi.apiProducto.repositories.ProductRepository;
import com.maxi.apiProducto.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productDB = productRepository.findByName(product.getName());
        if(!productDB.isPresent()){
            product.setCreatedAt(LocalDate.now());
            return productRepository.save(product); 
        }else{
            throw new EntityDuplicatedNameCreationException("Product name aleready exists");
        }
        
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> new EntityFindByIdNotFoundException("Prodict id not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = this.findProductById(id);
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product optionalProduct = findProductById(id);
        optionalProduct.setName(product.getName());
        optionalProduct.setDescription(product.getDescription());
        optionalProduct.setPrice(product.getPrice());
        return productRepository.save(optionalProduct);
    }    
}

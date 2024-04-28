package com.maxi.apiProducto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.apiProducto.models.Product;
import com.maxi.apiProducto.service.impl.ProductServiceImpl;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productServiceImpl.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(productServiceImpl.findAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        return new ResponseEntity<>(productServiceImpl.findProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProductById(@RequestParam("id") Long id){
        productServiceImpl.deleteProductById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productServiceImpl.updateProduct(product.getId(), product), HttpStatus.OK);
    }
}

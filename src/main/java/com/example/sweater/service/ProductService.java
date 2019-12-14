package com.example.sweater.service;

import com.example.sweater.domain.Product;
import com.example.sweater.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
public void delete(Long id){
    productRepo.deleteById(id);
}

public Optional<Product> findProductById(Long id){
    return productRepo.findById(id);
}
}

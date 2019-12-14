package com.example.sweater.repos;

import com.example.sweater.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findByTag(String tag);
    void deleteById(Long id);

    Optional<Product> findById(Long id);
    Product findProductById(Long id);
}

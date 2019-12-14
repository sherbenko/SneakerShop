package com.example.sweater.repos;

import com.example.sweater.domain.Basket;
import com.example.sweater.domain.Product;
import com.example.sweater.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasketRepo extends CrudRepository<Basket,Long> {
Iterable<Basket> findAllById(Long id);
Iterable<Basket> findAllByUser(User user);
Iterable<Basket> findAll();
void deleteBasketById(Long id);
}

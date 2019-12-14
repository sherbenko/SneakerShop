package com.example.sweater.service;

import com.example.sweater.domain.Basket;
import com.example.sweater.repos.BasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    @Autowired
    private BasketRepo basketRepo;
public void delete(Long id){
    basketRepo.deleteBasketById(id);
}

}

package com.example.sweater.controller;

import com.example.sweater.domain.Basket;
import com.example.sweater.domain.Product;
import com.example.sweater.domain.User;
import com.example.sweater.repos.BasketRepo;
import com.example.sweater.repos.ProductRepo;
import com.example.sweater.service.BasketService;
import com.example.sweater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BasketController {
    @Autowired
    private BasketRepo basketRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;

    @GetMapping("/basket")
    public String basket() {
        return "basket";
    }

    @GetMapping("/allbasket")
    public String getBasket(@AuthenticationPrincipal User user,
                            Map<String, Object> model) {

//        Basket basket = new Basket(productRepo.findProductById(id));
//        basketRepo.save(basket);

        Iterable<Basket> baskets = basketRepo.findAll();
//        baskets = basketRepo.findAllById(currentUserId);
        baskets = basketRepo.findAllByUser(user);
        model.put("baskets", baskets);

        return "basket";
    }
    @PostMapping("/addTobasket/{product_id}")
    public String addToBasket(@AuthenticationPrincipal User user,
                              @PathVariable Product product_id,
                              Map<String, Object> model){
        Basket basket = new Basket(product_id,user);
        basketRepo.save(basket);
        Iterable<Basket> baskets = basketRepo.findAllByUser(user);

        model.put("baskets", baskets);
        return "redirect:/main";
    }
    @GetMapping(value="/deleteItem/{id}")
    public String delete(@AuthenticationPrincipal User user,
                         @PathVariable Long id,
                         Map<String, Object> model){

        productService.delete(id);
        Iterable<Basket> baskets = basketRepo.findAll();

        model.put("baskets", baskets);
        return "redirect:/main";
    }
    @GetMapping("/ordersList")
    public String userList(Map<String,Object> model) {
        Iterable<Basket> baskets = basketRepo.findAll();
//        baskets = basketRepo.findAllById(currentUserId);
        baskets = basketRepo.findAll();
        model.put("baskets", baskets);

        return "ordersList";
    }

}

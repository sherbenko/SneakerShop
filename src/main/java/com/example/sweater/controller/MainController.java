package com.example.sweater.controller;

import com.example.sweater.domain.Product;
import com.example.sweater.domain.User;
import com.example.sweater.repos.ProductRepo;
import com.example.sweater.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByTag(filter);
        } else {
            products = productRepo.findAll();
        }

        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Product product = new Product(text, tag, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            product.setFilename(resultFilename);
        }

        productRepo.save(product);

        Iterable<Product> products = productRepo.findAll();

        model.put("products", products);

        return "main";
    }
    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable Long id,Map<String, Object> model){
        productService.delete(id);
        Iterable<Product> products = productRepo.findAll();

        model.put("products", products);
    return "redirect:/main";
    }


}

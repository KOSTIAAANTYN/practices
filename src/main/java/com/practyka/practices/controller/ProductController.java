package com.practyka.practices.controller;

import com.practyka.practices.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("productList", productService.getProductList());
        return "products";
    }
    @GetMapping("/yuschenko")
    public String returnIndex(Model model){
        model.addAttribute("productList", productService.getProductList());
        return "index";
    }
}

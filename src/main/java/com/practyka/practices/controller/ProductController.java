package com.practyka.practices.controller;

import com.practyka.practices.model.Product;
import com.practyka.practices.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
//    @GetMapping("/yuschenko")
////    public String products(Model model){
////        model.addAttribute("productList", productService.getProductList());
////        return "products";
////    }
    @GetMapping("/")
    public String returnIndex(@RequestParam(name = "title",required = false) String title, Model model){
        model.addAttribute("productList", productService.getProductList(title));
        return "index";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "product-info";
    }
    @PostMapping("product/delete/{id}")
    public String removeProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @PostMapping("/product/create")
    public String createProduct(@RequestParam(name = "file1") MultipartFile file1,
                                @RequestParam(name = "file2") MultipartFile file2,
                                @RequestParam(name = "file3") MultipartFile file3,
                                Product product){
        productService.saveProduct(product,file1,file2,file3);
        return "redirect:/";
    }
}

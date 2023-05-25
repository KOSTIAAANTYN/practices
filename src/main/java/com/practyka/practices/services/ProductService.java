package com.practyka.practices.services;

import com.practyka.practices.model.Product;
import com.practyka.practices.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return  productRepository.findById(id).orElse(null);
    }
}

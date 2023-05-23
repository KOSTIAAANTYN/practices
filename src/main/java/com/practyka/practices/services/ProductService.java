package com.practyka.practices.services;

import com.practyka.practices.model.Product;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList=new ArrayList<>();
    private long ID =0;

    {
        productList.add(new Product(++ID,"Iphone 10","New Iphone",20500,"Kherson","Ivan"));
        productList.add(new Product(++ID,"Mirror","New Mirror",20,"Kherson","Taras"));
        productList.add(new Product(++ID,"Xiomo pro 10x turbo boost","New Hiomi",500,"Kherson","Xio"));

    }

    public List<Product> getProductList() {
        return productList;
    }
}
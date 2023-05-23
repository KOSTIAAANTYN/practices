package com.practyka.practices.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String town;
    private String author;



}

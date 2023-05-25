package com.practyka.practices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="town")
    private String town;
    @Column(name="author")
    private String author;



}

package com.tts.ecommerce.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private int quantity;
    private double price;

    private String description;
    private String name;
    private String brand;
    private String category;
    private String image;

    public String getId() {
        return null;
    }
    
}

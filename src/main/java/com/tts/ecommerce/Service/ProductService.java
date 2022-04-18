package com.tts.ecommerce.Service;

import java.util.List;

import javax.validation.Valid;

import com.tts.ecommerce.Model.Product;
import com.tts.ecommerce.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<String> findDistinctCategories() {
        return productRepository.findDistinctCategories();
    }

    public List<String> findDistinctBrands() {
        return productRepository.findDistinctBrands();
    }

    public List<Product> findByBrandAndOrCategory(String brand, String category) {
        if(category == null && brand == null)
            return productRepository.findAll();
        else if(category == null)
            return productRepository.findByBrand(brand);
        else if (brand == null)
            return productRepository.findByCategory(category);
        else
            return productRepository.findByBrandAndCategory(brand, category);
    }

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}

package com.example.backend.service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product save(Product p) {
        return repo.save(p);
    }
    public Product updatePartial(Long id, Product updatedProduct) {
        Product existingProduct = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        if (updatedProduct.getName() != null) {
            existingProduct.setName(updatedProduct.getName());
        }

        if (updatedProduct.getDescription() != null) {
            existingProduct.setDescription(updatedProduct.getDescription());
        }

        if (updatedProduct.getImageUrl() != null) {
            existingProduct.setImageUrl(updatedProduct.getImageUrl());
        }

        if (updatedProduct.getPrice() != 0) {
            existingProduct.setPrice(updatedProduct.getPrice());
        }

        return repo.save(existingProduct);
    }

    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        repo.deleteById(id);
    }

}

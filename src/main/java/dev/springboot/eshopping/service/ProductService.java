package dev.springboot.eshopping.service;

import dev.springboot.eshopping.entity.Product;
import dev.springboot.eshopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsBySortOrder(Sort.Direction direction) {
        return productRepository.findAll(Sort.by(direction));
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}

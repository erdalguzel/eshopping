package dev.springboot.eshopping.service;

import dev.springboot.eshopping.entity.Product;
import dev.springboot.eshopping.exception.ProductNotFoundException;
import dev.springboot.eshopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsBySortOrder(Sort.Direction direction) {
        return productRepository.findAll(Sort.by(direction));
    }

    @Override
    public Product getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException(String.format("Product with id %d is not found", id));
        }
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
package dev.springboot.eshopping.service;

import dev.springboot.eshopping.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getAllProductsBySortOrder(Sort.Direction direction);

    void save(Product product);

    void delete(Product product);

}

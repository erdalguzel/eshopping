package dev.springboot.eshopping.service;

import dev.springboot.eshopping.entity.Product;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getById(int id);

    List<Product> getAllProductsBySortOrder(Sort.Direction direction);

    void save(Product product);

    void delete(Product product);

    void deleteById(int id);

}

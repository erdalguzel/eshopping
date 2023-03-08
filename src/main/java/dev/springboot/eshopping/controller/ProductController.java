package dev.springboot.eshopping.controller;

import dev.springboot.eshopping.entity.Product;
import dev.springboot.eshopping.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/list/{id}")
    public Product listProductById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productService.delete(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") int id) {
        productService.deleteById(id);
    }
}

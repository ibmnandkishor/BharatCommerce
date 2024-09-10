
package net.codejava.service;

import java.util.List;
import java.util.Optional;

import net.codejava.model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}
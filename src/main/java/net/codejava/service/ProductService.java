package net.codejava.service;

import net.codejava.model.Product;
<<<<<<< HEAD
=======

>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    Optional<Product> getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}

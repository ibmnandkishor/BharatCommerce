package net.codejava.repository;

<<<<<<< HEAD
import net.codejava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
=======
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.User;
import net.codejava.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // No additional code needed; JpaRepository provides CRUD methods

>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
}

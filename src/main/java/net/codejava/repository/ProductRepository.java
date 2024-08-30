package net.codejava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.User;
import net.codejava.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // No additional code needed; JpaRepository provides CRUD methods

}

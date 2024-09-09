package net.codejava.controller;

import net.codejava.User;
import net.codejava.UserRepository;
import net.codejava.model.Product;
import net.codejava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductService productService;

    private static final String UPLOADED_FOLDER = "uploads/";

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }
        return "products/profile";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }
        return "products/home";
    }

    @GetMapping("/user")
    public String listUsers(HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }
        
        // Fetch all users from the database
        List<User> listUsers = userRepo.findAll();
        
        // Add the list of users to the model
        model.addAttribute("listUsers", listUsers);
        
        // Return the view to display users
        return "products/user";
    }

    @GetMapping("/list")
    public String listProducts(HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("products", productService.getAllProducts());
        return "products/product-list";
    }

    @GetMapping("/create")
    public String showCreateProductForm(HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }
        model.addAttribute("product", new Product());
        return "products/create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product,
                                @RequestParam("image") MultipartFile file,
                                HttpSession session,
                                Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }

        // Save the file to the server
        if (!file.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOADED_FOLDER);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.write(filePath, file.getBytes());

                product.setImageUrl("/uploads/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "Failed to upload image");
                return "products/create-product";
            }
        }

        productService.saveProduct(product);
        model.addAttribute("product", product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }

        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isPresent()) {
            model.addAttribute("product", productOpt.get());
            return "products/edit-product";
        } else {
            return "redirect:/products/list";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,
                                @ModelAttribute Product product,
                                @RequestParam("image") MultipartFile file,
                                HttpSession session,
                                Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }

        Optional<Product> existingProductOpt = productService.getProductById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());

            if (!file.isEmpty()) {
                try {
                    if (existingProduct.getImageUrl() != null) {
                        Path oldFilePath = Paths.get(UPLOADED_FOLDER + existingProduct.getImageUrl().substring("/uploads/".length()));
                        Files.deleteIfExists(oldFilePath);
                    }

                    String fileName = file.getOriginalFilename();
                    Path filePath = Paths.get(UPLOADED_FOLDER + fileName);
                    Files.write(filePath, file.getBytes());

                    existingProduct.setImageUrl("/uploads/" + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("error", "Failed to upload image");
                }
            }

            productService.saveProduct(existingProduct);
            model.addAttribute("product", existingProduct);
            return "products/product-success";
        } else {
            return "redirect:/products/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, HttpSession session, Model model) {
        // Check if admin is logged in
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/admin";
        }

        Optional<Product> productOpt = productService.getProductById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            if (product.getImageUrl() != null) {
                try {
                    Path filePath = Paths.get(UPLOADED_FOLDER + product.getImageUrl().substring("/uploads/".length()));
                    Files.deleteIfExists(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    model.addAttribute("error", "Failed to delete image");
                }
            }

            productService.deleteProduct(id);
            model.addAttribute("message", "Product deleted successfully");
        } else {
            model.addAttribute("error", "Product not found");
        }
        return "redirect:/products/list";
    }
}
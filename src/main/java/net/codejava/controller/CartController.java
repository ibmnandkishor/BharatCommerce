package net.codejava.controller;

import javax.servlet.http.HttpSession;
import net.codejava.service.CartService;
import net.codejava.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public String addToCart(
        @RequestParam("productId") long productId, // Changed to long for better type safety
        @RequestParam("quantity") int quantity,
        HttpSession session,
        Model model
    ) {
        // Check if user is logged in
        if (session.getAttribute("userLoggedIn") == null) {
            return "redirect:/user_login"; // Redirect to login if not logged in
        }

        try {
            // Add item to cart
            cartService.addItemToCart(session, productId, quantity);
        } catch (Exception e) {
            // Handle exceptions (e.g., invalid productId)
            model.addAttribute("errorMessage", "Unable to add item to cart. Please try again.");
            return "error"; // Return to an error view
        }

        // Retrieve cart items and add them to the model
        model.addAttribute("cartItems", cartService.getCartItems(session));

        return "user"; // Return the view name for displaying the cart
    }

    @GetMapping("/viewCart")
    public String viewCart(HttpSession session, Model model) {
        // Retrieve cart items and add them to the model
        model.addAttribute("cartItems", cartService.getCartItems(session));
        return "view"; // Return the view name for displaying the cart
    }
}

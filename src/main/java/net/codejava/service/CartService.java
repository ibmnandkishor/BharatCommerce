package net.codejava.service;

import net.codejava.model.CartItem;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static final String CART_SESSION_KEY = "cartItems";

    public void addItemToCart(HttpSession session, long productId, int quantity) {
        // Retrieve the cart from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute(CART_SESSION_KEY, cartItems);
        }

		/*
		 * // Check if the item is already in the cart boolean itemExists = false; for
		 * (CartItem item : cartItems) { if (item.getProductId() == productId) {
		 * item.setQuantity(item.getQuantity() + quantity); itemExists = true; break; }
		 * }
		 * 
		 * // If item doesn't exist, add it to the cart if (!itemExists) { CartItem
		 * newItem = new CartItem(); newItem.setProductId(productId);
		 * newItem.setQuantity(quantity); cartItems.add(newItem); }
		 */
    }

    public List<CartItem> getCartItems(HttpSession session) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute(CART_SESSION_KEY);
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        return cartItems;
    }
}

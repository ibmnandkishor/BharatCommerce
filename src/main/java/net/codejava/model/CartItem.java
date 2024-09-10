package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.codejava.User;

@Entity
public class CartItem {

    @Id
    private String productId;  // Assuming productId is unique and serves as an identifier
    private int quantity;

    @ManyToOne
    private User user; // Reference to User entity

    // Constructors
    public CartItem() {}

    public CartItem(String productId, int quantity, User user) {
        this.productId = productId;
        this.quantity = quantity;
        this.user = user;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public void setProductId(long productId2) {
		// TODO Auto-generated method stub
		
	}
}

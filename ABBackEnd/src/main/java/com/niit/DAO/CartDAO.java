package com.niit.DAO;

import java.util.List;

import com.niit.Model.Cart;


public interface CartDAO {

	public boolean addCartItem(Cart cartItem);
	public boolean updateCartItem(Cart cartItem);
	public boolean deleteCartItem(Cart cartItem);
	public List<Cart> listCartItems(String username);
	public Cart getCartItem(int cartItemID);
	
}

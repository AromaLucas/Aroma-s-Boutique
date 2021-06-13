package com.niit.DAO;

import java.util.List;


import com.niit.Model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> listProducts();
	public List<Product> searchProducts(String productName);
	public List<Product> listProductsBasedOnCategory(int categoryId);
	public Product getProduct(int productId);
	
}

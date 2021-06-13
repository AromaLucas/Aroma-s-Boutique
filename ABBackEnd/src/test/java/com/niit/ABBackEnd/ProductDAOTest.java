package com.niit.ABBackEnd;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.niit.DAO.*;
import com.niit.Model.Product;

public class ProductDAOTest {
	
static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}


	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		
		product.setProductName("Avon Lovely");
		product.setProductDesc("Lovely lipstick from Avon Brand with All colors");
		product.setStock(20);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(16000);
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		
		product.setPrice(1500);
		product.setStock(40);
		
		assertTrue("Problem in Updating Product",productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test 
	public void listProductsTest()
	{
		List<Product> productList=productDAO.listProducts();
		
		assertTrue("Problem in Retrieving the List of Products",productList.size()>0);
		
		for(Product product:productList)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}
	@Ignore
	@Test 
	public void listProductsCategoryWiseTest()
	{
		List<Product> productList=productDAO.listProductsBasedOnCategory(1);
		
		assertTrue("Problem in Retrieving the List of Products",productList.size()>0);
		
		System.out.println("==================Category Wise==================");
		for(Product product:productList)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}
	
	
	@Test 
	public void searchProductsTest()
	{
		List<Product> productList=productDAO.searchProducts("Avon Lovely");
		
		assertTrue("Problem in Retrieving the List of Products",productList.size()>0);
		
		System.out.println("==================search==================");
		for(Product product:productList)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getPrice()+":::");
		}
	}


}

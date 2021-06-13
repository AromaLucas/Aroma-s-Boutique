package com.niit.ABBackEnd;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CartDAO;
import com.niit.Model.Cart;

public class CartDAOTest {
static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCartItemTest()
	{
		Cart cartItem=new Cart();
		
		cartItem.setProductId(2);
		cartItem.setProductName("Avon Lovely");
		cartItem.setQuantity(2);
		cartItem.setPrice(1600);
		cartItem.setStatus("NP");
		cartItem.setUsername("zoe123");
		
		assertTrue("Problem in Adding CartItem",cartDAO.addCartItem(cartItem));
		
	}
	
	
	@Test
	public void deleteCartItemTest()
	{
		Cart cartItem=cartDAO.getCartItem(1);
		assertTrue("Problem in deleting CartItem",cartDAO.deleteCartItem(cartItem));
	}

	
}

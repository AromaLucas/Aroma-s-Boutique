package com.niit.ABBackEnd;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.OrderDAO;
import com.niit.Model.OrderDetail;
public class OrderDAOTest {
	
static OrderDAO orderDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Test
	public void testPayment()
	{
		OrderDetail orderInfo=new OrderDetail();
		orderInfo.setOrderDate(new java.util.Date());
		orderInfo.setTotalAmount(16000);
		orderInfo.setUsername("zoe123");
		orderInfo.setPaymentMode("COD");
		
		assertTrue("Problem in Order Payment",orderDAO.payment(orderInfo));
		assertTrue("Problem in Updating Payment",orderDAO.updateCartItemsStatus(orderInfo.getUsername(),orderInfo.getOrderId()));
	}



}

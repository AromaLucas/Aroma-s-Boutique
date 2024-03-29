package com.niit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CartDAO;
import com.niit.DAO.OrderDAO;
import com.niit.DAO.UserDAO;
import com.niit.Model.Cart;
import com.niit.Model.OrderDetail;

@Controller
public class PaymentController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/payment")
	public String makePayment(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		m.addAttribute("address", userDAO.getUser(username).getAddress());
		
		
		return "Payment";
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(Model m, HttpSession session,@RequestParam("pmode")String paymentMode,@RequestParam("S_add")String ShippingAddress)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		double total_Amount=this.totalCartValue(cartItemList);
		
		m.addAttribute("total_Amount",total_Amount);
		m.addAttribute("customerName", userDAO.getUser(username).getCustomerName());
		m.addAttribute("address1", userDAO.getUser(username).getAddress());
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setTotalAmount(total_Amount);
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentMode(paymentMode);
		orderDetail.setShippingAddress(ShippingAddress);
		
		if(orderDAO.payment(orderDetail))
		{
			orderDAO.updateCartItemsStatus(username, orderDetail.getOrderId());
		}
		
		m.addAttribute("order", orderDetail);
		m.addAttribute("customerName", userDAO.getUser(username).getCustomerName());
		m.addAttribute("address1", userDAO.getUser(username).getAddress());
		
		return "Receipt";
	}
	
	public double totalCartValue(List<Cart> cartItemList)
	{
		double totalCost=0;
		int i=0;
		
		while(i<cartItemList.size())
		{
			Cart cartItem=cartItemList.get(i);
			totalCost=totalCost+(cartItem.getPrice()*cartItem.getQuantity());
			i++;
		}
		
		return totalCost;
	}
	

}
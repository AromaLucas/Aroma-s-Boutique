package com.niit;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.UserDAO;
import com.niit.Model.Category;
import com.niit.Model.Product;
import com.niit.Model.User;

@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

		
	@RequestMapping("/login")
	public String showLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping("/register")
	public String showRegisterPage()
	{
		return "Register";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String registeruser(@RequestParam("Customer name")String cname,
			@RequestParam("Email Id")String email,
			@RequestParam("Mobile number")String mobile ,
			@RequestParam("Address_Line1")String address,
			@RequestParam("Username")String uname,
			@RequestParam("Password")String pword,Model m)
	{
User user=new User();
		
		user.setUsername(uname);
		user.setCustomerName(cname);
		user.setAddress(address);
		user.setEmail(email);
		user.setEnabled(true);
		user.setNumber(mobile);
		user.setPassword(pword);
		user.setRole("ROLE_USER");
		
		userDAO.registerUser(user);
		m.addAttribute("user", user);
		return "Login";
	}
	
	
	@RequestMapping("/contactUs")
	public String showContactUsPage()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/home")
	public String showhome(MultipartFile imgf, Model m)
	{	
		return "GeneralHome";
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchProduct(@RequestParam("prodName")String productName,Model m)
	{
		Product product=new Product();
		List<Product> productList=productDAO.searchProducts(productName);
		
		m.addAttribute("product", product);
		m.addAttribute("productList", productList);
				
		return "ProductDisplay";
	}
	
	
	
	
	
}
package com.niit;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.CategoryDAOImpl;
import com.niit.Model.Category;

@Controller
public class CategoryController
{
	
	@Autowired 
	CategoryDAO CategoryDAO;
	
	@RequestMapping("/manageCategory")
	public String showCategoryPage(Model m)
	{
		
		List<Category> categoryList=CategoryDAO.listCategories();
		  m.addAttribute("categoryList", categoryList);
		 
		return "manageCategory";
	}
	
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")String categoryName,Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		
		
		CategoryDAO.addCategory(category);
		
		List<Category> categoryList=CategoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "manageCategory";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName")String categoryName,Model m)
	{
		Category category=CategoryDAO.getCategory(categoryId);
		
		category.setCategoryName(categoryName);
		
		
		CategoryDAO.updateCategory(category);
		
		List<Category> categoryList=CategoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "manageCategory";
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=CategoryDAO.getCategory(categoryId);
		m.addAttribute("category",category);
		return "UpdateCategory";
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=CategoryDAO.getCategory(categoryId);
		
		CategoryDAO.deleteCategory(category);
		
		List<Category> categoryList=CategoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "manageCategory";
		
	}
	
}

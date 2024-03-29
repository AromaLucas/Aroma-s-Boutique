package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.Model.Product;
import com.niit.Model.Category;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Product> listProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> productList=query.list();
		session.close();
		return productList;
	}

	public List<Product> searchProducts(String productName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where productName=:prodName");
		query.setParameter("prodName", productName);
		List<Product> productList=query.list();
		session.close();
		return productList;
	}

	public List<Product> listProductsBasedOnCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:catid");
		query.setParameter("catid", categoryId);
		List<Product> productList=query.list();
		session.close();
		return productList;
	}

	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		return product;
	}

}

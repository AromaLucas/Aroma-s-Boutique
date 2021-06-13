package com.niit.DAO;

import java.util.List;

import com.niit.Model.Cart;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.Model.Product;
import com.niit.Model.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCartItem(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteCartItem(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Cart> listCartItems(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:uname and status='NP'");
		query.setParameter("uname", username);
		List<Cart> cartItemList=query.list();
		session.close();
		return cartItemList;
	}

	public Cart getCartItem(int cartItemID) {
		Session session=sessionFactory.openSession();
		Cart cartItem=session.get(Cart.class, cartItemID);
		session.close();
		return cartItem;
	}

}

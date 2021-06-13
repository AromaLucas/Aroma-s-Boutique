package com.niit.DAO;

import java.util.List;

import com.niit.Model.Suplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.Model.Product;
import com.niit.Model.Category;

@Repository("suplierDAO")
@Transactional
public class SuplierDAOImpl implements SuplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSuplier(Suplier suplier) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(suplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateSuplier(Suplier suplier) {
		
			try
			{
				sessionFactory.getCurrentSession().update(suplier);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}

	public boolean deleteSuplier(Suplier suplier) {
		
			try
			{
				sessionFactory.getCurrentSession().delete(suplier);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}

	public List<Suplier> listSupliers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Suplier> listSupliers=query.list();
		session.close();
		return listSupliers;
	}

	public Suplier getSuplier(int suplierId) {
		Session session=sessionFactory.openSession();
		Suplier suplier=(Suplier)session.get(Suplier.class, suplierId);
		session.close();
		return suplier;
	}

}

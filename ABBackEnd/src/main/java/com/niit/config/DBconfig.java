package com.niit.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Model.Cart;
import com.niit.Model.Category;
//import com.niit.Model.Order;
import com.niit.Model.OrderDetail;
import com.niit.Model.Product;
import com.niit.Model.Suplier;
import com.niit.Model.User;



@Configuration
@EnableTransactionManagement
public class DBconfig {
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test1");
		System.out.println("Creating DataSource bean");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProps = new Properties();
		hibernateProps.put("hibernate.hbm2ddl.auto", "update");
		hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(this.getH2DataSource());
		factory.addProperties(hibernateProps);
		factory.addAnnotatedClass(User.class);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Cart.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(OrderDetail.class);
		factory.addAnnotatedClass(Suplier.class);
		SessionFactory ssf = factory.buildSessionFactory();
		System.out.println("Session Factory created");
		return ssf;
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory ssf) {
		System.out.println("HibernateTransactionManager obj created");
		return new HibernateTransactionManager(ssf);
	}

}

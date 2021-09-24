package com.revature.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.revature.pms.model.Product;


public class ProductDAOImpl implements ProductDAO {
	private static Logger logger = Logger.getLogger("ProductDAOImpl");

	Configuration configuration = new Configuration().configure();    //hibernate.cfg.xml
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	
	// THis will add product in DB
	public boolean addProduct(Product product) {
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		return true;
	}

	public boolean deleteProduct(int productId) {
		Transaction transaction = session.beginTransaction();
		Product product = new Product();
		product.setProductId(productId);
		session.delete(product);
		transaction.commit();
		return true;

		
	}

	public boolean updateProduct(Product product) {
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		return true;
		
	}

	public Product getProductById(int productId) {
		Product product = session.get(Product.class, productId);
		return product;
		
	}
	//To do 
	public List<Product> getProductByName(String productName) {
		Query<Product> query = session.createQuery("from com.revature.pms.model.Product where productName = '"+productName+"'");
		return query.list();
		
	}

	public List<Product> getAllProducts() {
		Query<Product> query = session.createQuery("from com.revature.pms.model.Product");
		return query.list();

		
	}

	public boolean isProductExists(int productId) {
		Product product = session.get(Product.class, productId);
		if(product == null) {
			return false;
		}
		else {
			return true;
		}
	}

}

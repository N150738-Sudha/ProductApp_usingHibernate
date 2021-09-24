package com.revature.pms.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Product;

public class ProductDAOImplTest {
	ProductDAO productDAO = new ProductDAOImpl();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productDAO = new ProductDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddProduct() {
		int productId=3;
		Product product = new Product(productId,"Lakme",20,2300,"Good");
		assertEquals(true,productDAO.addProduct(product));
	}

	@Test
	public void testDeleteProduct() {
		int productId=1;
		assertEquals(true,productDAO.deleteProduct(productId));
	}

	@Test
	public void testUpdateProduct() {
		int productId = 2;
		Product product = new Product(productId,"Aroma",20,2300,"Good");
		assertEquals(true,productDAO.updateProduct(product));
	}

	@Test
	public void testGetProductById() {
		int productId=2;
		Product product = productDAO.getProductById(productId);
		assertNotNull(product);
	}

	@Test
	public void testGetProductByName() {
		List<Product> products = productDAO.getProductByName("shirt");
		assertEquals(1,products.size());
	}

	@Test
	public void testGetAllProducts() {
		List<Product> products = productDAO.getAllProducts();
		assertEquals(1,products.size());
	}

	@Test
	public void testIsProductExists() {
		int productId = 2;
		assertEquals(true,productDAO.isProductExists(productId));
	}

}

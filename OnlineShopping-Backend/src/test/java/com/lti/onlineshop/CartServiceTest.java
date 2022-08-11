package com.lti.onlineshop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.beans.Cart;
import com.lti.beans.Category;
import com.lti.beans.Product;
import com.lti.beans.Retailer;
import com.lti.beans.User;
import com.lti.dao.CartDao;
import com.lti.excep.DotStoreExcep;
import com.lti.services.CartService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CartServiceTest {

	@Autowired
	CartService service;

	@MockBean
	CartDao dao;
	
	User user = new User(111,"Akash","akash@gmail.com","9988776655","Akash@123","DFGn6gvb","Warangal","Male","21/05/2022");
	Category category1 = new Category(1,"clothing","for everyone");
	Retailer retailer1 = new Retailer(1111,"Kiara","Kohinoor","kiara@gmail.com",859747,"KairaKohinoor",true,"Patna");
	Product product1 = new Product(11,"Nebora Leather Belt","Formal Belt With Branded Pinup Buckle",1249,9,true,"../assets/images/29.jpeg",category1,retailer1);
	Cart cart = new Cart(17,56,user,product1);
	
	@Test
	public void testAddCart()
	{
		Mockito.when(dao.addCart(cart)).thenReturn(cart);
		assertEquals(service.addCart(cart), cart);
	}
	
	@Test
	public void testGetProductByUserId() throws DotStoreExcep
	{
		List<Cart> cartList = new ArrayList<Cart>();
		cartList.add(cart);
		Mockito.when(dao.getProductsByUserId(cart.getUser().getUser_id())).thenReturn(cartList);
		assertEquals(service.getProductsByUserId(cart.getUser().getUser_id()), cartList);
	}
	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

}

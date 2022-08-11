package com.lti.onlineshop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.beans.Category;
import com.lti.beans.Order;
import com.lti.beans.Product;
import com.lti.beans.Retailer;
import com.lti.beans.User;
import com.lti.dao.OrderDao;
import com.lti.excep.DotStoreExcep;
import com.lti.services.OrderService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrderServiceTest {

	@Autowired
	OrderService service;
	
	@MockBean
	OrderDao dao;
	
	User user = new User(111,"Akash","akash@gmail.com","9988776655","Akash@123","DFGn6gvb","Warangal","Male","21/05/2022");
	Category category1 = new Category(1,"clothing","for everyone");
	Retailer retailer1 = new Retailer(1111,"Kiara","Kohinoor","kiara@gmail.com",859747,"KairaKohinoor",true,"Patna");
	Product product1 = new Product(11,"Nebora Leather Belt","Formal Belt With Branded Pinup Buckle",1249,9,true,"../assets/images/29.jpeg",category1,retailer1);
	Order order = new Order(118,3,10497,"22/07/2022",2,user,product1);
	
	
	@Test
	public void testAddCart()
	{
		Mockito.when(dao.addOrder(order)).thenReturn(order);
		assertEquals(service.addOrder(order), order);
	}
	
	@Test
	public void testGetProductByUserId() throws DotStoreExcep
	{
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		Mockito.when(dao.getOrdersByUserId(order.getUser().getUser_id())).thenReturn(orderList);
		assertEquals(service.getOrdersByUserId(order.getUser().getUser_id()), orderList);
	}
	
	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

}

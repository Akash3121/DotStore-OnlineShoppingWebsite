package com.lti.services;

import java.util.List;

import com.lti.beans.Order;
import com.lti.excep.DotStoreExcep;

public interface OrderService {
	
	public Order addOrder(Order o);
	public List<Order> getOrdersByUserId(int user_id)throws DotStoreExcep;

}

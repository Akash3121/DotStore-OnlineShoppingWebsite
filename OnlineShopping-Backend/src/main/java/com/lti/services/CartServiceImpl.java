package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Cart;
import com.lti.dao.CartDao;
import com.lti.excep.DotStoreExcep;

@Service(value="cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao dao;
	
	@Override
	public Cart addCart(Cart c) {
		return dao.addCart(c);
	}

	@Override
	public List<Cart> getProductsByUserId(int user_id) throws DotStoreExcep {
		List<Cart> cartList= dao.getProductsByUserId(user_id);
		if (cartList.size()>0)
		{
			return cartList;
		}
		else
		{
			throw new DotStoreExcep("Products not present with User Id: "+user_id);
		}
	}


}

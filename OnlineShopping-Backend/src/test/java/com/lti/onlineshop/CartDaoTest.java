package com.lti.onlineshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.dao.CartDao;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class CartDaoTest {
	
	@Autowired
	CartDao dao;
	
//	public void test

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

}

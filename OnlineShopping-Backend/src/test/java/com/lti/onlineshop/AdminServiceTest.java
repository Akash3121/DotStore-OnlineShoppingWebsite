package com.lti.onlineshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.beans.Admin;
import com.lti.dao.AdminDao;
import com.lti.services.AdminService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AdminServiceTest {
	
	@Autowired
	AdminService service;
	
	@MockBean
	AdminDao dao;

	@Test
	public void testAdminEmailExist()
	{
		Admin admin = new Admin(0,"Rishi","rishi@gmail.com", "Rishi@123");
		Mockito.when(dao.adminEmailExist(admin.getEmail())).thenReturn(admin);
		assertEquals(service.adminEmailExist(admin.getEmail()), admin);
	}
	
	
	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

}

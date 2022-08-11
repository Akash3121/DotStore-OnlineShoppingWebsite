package com.lti.onlineshop;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.beans.Admin;
import com.lti.dao.AdminDao;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AdminDaoTest {
	
	@Autowired
	AdminDao dao;
	

	
	@Test
	public void testAddAdmin()
	{
		//don't use same id /pk in here
		Admin admin = new Admin(0,"Rishi","rishi@gmail.com", "Rishi@123");
		
		Admin returnedAdmin= dao.adminEmailExist(admin.getEmail());
		assertNotNull(returnedAdmin);//assertThat(admin.getAdmin_id()).isGreaterThan(0)
		assertEquals(returnedAdmin,admin);
	}

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

}

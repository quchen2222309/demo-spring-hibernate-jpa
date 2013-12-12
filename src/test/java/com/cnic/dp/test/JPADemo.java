package com.cnic.dp.test;

import javax.annotation.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.service.CustomerService;


@RunWith(value=SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml"}) 
@Transactional 
public class JPADemo {
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setName("tom");
		customerService.save(c);
	}
	
	@Test
	public void testRefresh() {
		Customer c = customerService.findOne(10);
		c.setName("lily");
		customerService.refresh(c);
	}
	
	@Test
	public void testQuery() {
		customerService.findByQueryBuilder();
	}
}
	

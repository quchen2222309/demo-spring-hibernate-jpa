package com.cnic.dp.test;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@RunWith(value=SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
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
	

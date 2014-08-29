package com.cnic.dp.test;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.bean.Product;
import cn.cnic.dp.service.CustomerService;
import cn.cnic.dp.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(value=SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class JPADemo {
	
	@Resource(name="customerService")
	private CustomerService customerService;

    @Resource(name = "productService")
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        Product p = new Product();
        p.setCode("HSNGD2032");
        p.setProductName("SAMSUMG");
        productService.save(p);
    }
	
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setName("tofdsss");
		customerService.save(c);
	}
	
	@Test
	public void testRefresh() {
		Customer c = customerService.findOne(1);
		c.setName("lilyd");
		customerService.refresh(c);
	}

    @Test
    public void testRemove() {
        Customer c = new Customer();
        c.setId(6);
        customerService.remove(c);
    }

    @Test
    public void testMerge(){
        Customer c = new Customer();
        c.setId(6);
        c.setName("xxx");
        customerService.merge(c);
    }

    @Test
    public void testTransaction() {
        Customer c = new Customer();
        c.setId(16);
        c.setName("pangbo");
        customerService.trans(c);
    }

	@Test
	public void testQuery() {
		customerService.findByQueryBuilder();
	}
}
	

package cn.cnic.dp.dao;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.util.PageUtil;

import java.util.List;

public interface CustomerDao {
    public void save (Customer customer);
    public void merge(Customer customer);
    public void refresh(Customer customer);
    public List<Customer> findByQueryBuilder();
	public Customer findOne(Integer id);
	public void remove(Customer customer);
	public PageUtil<Customer> findCustomerPage(Integer pageNo, Integer pageSize);
	public Integer countCustomer();
}

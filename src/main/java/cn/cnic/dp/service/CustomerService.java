package cn.cnic.dp.service;

import java.util.List;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.util.PageUtil;

public interface CustomerService {
    public void save(Customer customer);
    public void merge(Customer customer);
    public void refresh(Customer customer);
    public void remove(Integer id);
    public Customer findOne(Integer id);
    public List<Customer> findByQueryBuilder();
    public PageUtil<Customer> findCustomerPage(Integer pageNo, Integer pageSize);
}

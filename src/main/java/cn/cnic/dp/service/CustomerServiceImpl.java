package cn.cnic.dp.service;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.dao.CustomerDao;
import cn.cnic.dp.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{
   
    private CustomerDao customerDao ;
    @Resource
    public void setCustomerDao(CustomerDao customerDao) {
       this.customerDao = customerDao;
    }
    @Transactional
    public void save(Customer customer) {
       customerDao.save(customer);
    }

    @Transactional
    public void merge(Customer customer) {
    	customerDao.merge(customer);
    }

    @Transactional
    public void refresh(Customer customer) {
    	customerDao.refresh(customer);
    }

    @Transactional
    public void remove(Customer customer) {
    	customerDao.remove(customer);
    }

    @Transactional
    public void trans(Customer customer) {
        customerDao.merge(customer);
        customerDao.remove(customer);
    }

    public List<Customer> findByQueryBuilder() {
		return customerDao.findByQueryBuilder();
	}
	public Customer findOne(Integer id) {
		return customerDao.findOne(id);
	}
	public PageUtil<Customer> findCustomerPage(Integer pageNo, Integer pageSize) {
		return customerDao.findCustomerPage(pageNo, pageSize);
	}
}

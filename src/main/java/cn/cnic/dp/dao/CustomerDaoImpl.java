package cn.cnic.dp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.util.PageUtil;

@Repository(value = "customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Customer customer) {
		entityManager.persist(customer);
	}
	
	public void merge(Customer customer) {
		entityManager.merge(customer);
	}
	
	public void refresh(Customer customer) {
		Customer c = entityManager.find(Customer.class, 1);
		c.setName("fuck");
		entityManager.refresh(c);
		System.out.println(c);
	}
	
	public void remove(Integer id) {
		Customer c = entityManager.find(Customer.class, id);
		entityManager.remove(c);
	}
	/**
	 * JPQL
	 * @return
	 */
	public List<Customer> findAllByJPQL() {
		@SuppressWarnings("unchecked")
		List<Customer> customers = entityManager.createQuery("from Customer c where id=:id")
												.setParameter("id", 1)
												.getResultList();
		return customers;
		
	}
	/**
	 * CriteriaBuilder
	 * @return
	 */
	public List<Customer> findByQueryBuilder() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);
		Root<Customer> user = criteriaQuery.from(Customer.class);
		Predicate predicate = cb.conjunction();
		predicate.getExpressions().add(cb.equal(user.get("id"), 1));
		criteriaQuery.where(predicate);
		List<Customer> customers = entityManager.createQuery(criteriaQuery).getResultList();
		return customers;
	}
	
	public PageUtil<Customer> findCustomerPage(Integer pageNo, Integer pageSize) {
		int total = this.countCustomer();
		PageUtil<Customer> page = new PageUtil<Customer>(total, pageNo, pageSize);
		@SuppressWarnings("unchecked")
		List<Customer> customers = entityManager.createQuery("from Customer c")
					.setFirstResult(page.getRowFrom())
					.setMaxResults(page.getPageSize())
					.getResultList();
		page.setContent(customers);
		return page;
	}
	
	public Customer findOne(Integer id) {
		return entityManager.find(Customer.class, id);
	}

	public Integer countCustomer() {
		return Integer.parseInt(Long.toString((Long)entityManager.createQuery("select count(*) from Customer c").getSingleResult()));
	}
}

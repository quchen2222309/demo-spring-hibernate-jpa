package cn.cnic.dp.dao;

import cn.cnic.dp.bean.Product;
import org.springframework.data.repository.Repository;

/**
 * Created by pangbo on 2014/8/29. good day commander!
 */
public interface ProductDao extends Repository<Product, Integer> {

    public Product save(Product product);
}

package cn.cnic.dp.service;

import cn.cnic.dp.bean.Product;
import cn.cnic.dp.dao.ProductDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pangbo on 2014/8/29.
 * good day commander!
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    @Transactional
    public void save(Product product) {
        productDao.save(product);
    }
}

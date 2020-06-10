package com.whw.service;

import com.whw.dao.ProductDao;
import com.whw.domain.Product;
import com.whw.util.PageCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao dao;

    /**
     * 根据商品id 查询商品
     *
     * @param id 商品id
     * @return 商品
     */
    public Product findById(int id) {
        try {
            return dao.findById(id);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 增加商品
     *
     * @param product 商品
     * @return 商品id
     */
    public int save(Product product) {
        try {
            return dao.save(product);
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 根据不同的分类查询不同的商品  分页查询
     *
     * @param id    分类id
     * @param first 启示索引
     * @param max   查询数量
     * @return 结果
     */
    public PageCategory findByCategoryId(int id, int pageNumber) {
        PageCategory<Product> page = PageCategory.startPage(pageNumber,count(id));
        int startPage = PageCategory.pageStart(page.getPageNumber());
        List<Product> list = dao.findByCategoryId(id, startPage, 10);
        page.setList(list);
        return page;
    }

    /**
     * 查询当前分类的总商品数量
     *
     * @param id 分类id
     * @return 总商品数量
     */
    public int count(int id) {
        return dao.count(id);
    }

    /**
     * 删除商品
     *
     * @param o
     */
    public void update(Product o) {
        dao.update(o);
    }
}

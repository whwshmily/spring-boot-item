package com.whw.service;

import com.whw.domain.Product;
import com.whw.util.PageCategory;

import java.util.List;

public interface IProductService {
    /**
     * 根据商品id 查询商品
     *
     * @param id 商品id
     * @return 商品
     */
    Product findById(int id);

    /**
     * 增加商品
     *
     * @param product 商品
     * @return 商品id
     */
    int save(Product product);

    /**
     * 根据不同的分类查询不同的商品  分页查询
     *
     * @param id    分类id
     * @param first 启示索引
     * @param max   查询数量
     * @return 结果
     */
    PageCategory findByCategoryId(int id, int pageNumber);

    /**
     * 查询当前分类的总商品数量
     * @param id 分类id
     * @return 总商品数量
     */
    int count(int id);

    /**
     * 删除商品
     * @param o
     */
    void update(Product o);
}

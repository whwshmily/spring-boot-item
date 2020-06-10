package com.whw.service;

import com.whw.dao.CategoryDao;
import com.whw.domain.Cart;
import com.whw.domain.Category;
import com.whw.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryDao dao;

    /**
     * 查询所有的一级分类
     *
     * @return 所有的一级分类
     */
    @Override
    public List<Category> findAllOneLevelCategory() {
        return dao.findByParentId(1);
    }

    /**
     * 根据父id 查询父id下所有的分类
     *
     * @param id 父id
     * @return 所有的分类
     */
    @Override
    public List<Category> findByParentId(int id) {
        return dao.findByParentId(id);
    }

    /**
     * 根据id 查询 具体的category
     *
     * @param id id
     * @return category
     */
    @Override
    public Category findById(int id) {
        return dao.findById(id);
    }

    /**
     * 根据id查询书籍 并排序
     *
     * @param categoryId  分类id
     * @param orderByName 排序的字段
     * @param sortType    升序 或降序
     * @return 书籍集合
     */
    @Override
    public List<Product> findByCategoryIdAndSort(int categoryId, String orderByName, String sortType) {
        return dao.findByCategoryIdAndSort(categoryId, orderByName, sortType);
    }


    /**
     * 模糊查询
     *
     * @param content 查询的字段
     * @return 书籍结果
     */
    @Override
    public List<Product> findByLikeSearch(String content) {
        return dao.findByLikeSearch(content);
    }

    /**
     * 根据id 查询 书籍
     *
     * @param id id
     * @return 书籍
     */
    @Override
    public Product findByProductId(int id) {
        return dao.findByProductId(id);
    }

    /**
     * 根据用户 id  查询购物车
     *
     * @param userId 用户id
     * @return 购物车信息
     */
    @Override
    public List<Cart> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }

    /**
     * 跟新用户购物车用相同产品的属性
     *
     * @param cart 购物车信息
     * @return 1 成功
     */
    @Override
    public int updateByCartId(Cart cart) {
        return dao.updateByCartId(cart);
    }

    /**
     * 新增 购物车
     *
     * @param cart 购物车信息
     * @return 1成功
     */
    @Override
    public int insertCart(Cart cart) {
        return dao.insertCart(cart);
    }

    /**
     * 根据用户id 和产品 id 查询 对应的购物车
     *
     * @param userId     用户id
     * @param product_id 产品id
     * @return 购物车
     */
    @Override
    public Cart findByUserIdAndProductId(int userId, int product_id) {
        return dao.findByUserIdAndProductId(userId,product_id);
    }

    /**
     * 根据用户id 和商品id 删除购物车
     *
     * @param userId     用户id
     * @param product_id 商品id
     * @return 1成功
     */
    @Override
    public int deleteByUserIdAndProduct(int userId, int product_id) {
        return dao.deleteByUserIdAndProduct(userId,product_id);
    }

    /**
     * 删除用户所有的购物车
     *
     * @param userId 用户id
     * @return 删除的条数
     */
    @Override
    public int deleteByUserId(int userId) {
        return dao.deleteByUserId(userId);
    }
}

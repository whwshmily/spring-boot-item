package com.whw.service;

import com.whw.domain.Cart;
import com.whw.domain.Category;
import com.whw.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICategoryService {
    /**
     * 查询所有的一级分类
     * @return  所有的一级分类
     */
    List<Category> findAllOneLevelCategory();

    /**
     * 根据父id 查询父id下所有的分类
     * @param id  父id
     * @return  所有的分类
     */
    List<Category> findByParentId(int id);

    /**
     *  根据id 查询 具体的category
     * @param id id
     * @return category
     */
    Category findById(int id);

    /**
     * 根据id查询书籍 并排序
     * @param categoryId  分类id
     * @param orderByName  排序的字段
     * @param sortType  升序 或降序
     * @return  书籍集合
     */
    List<Product> findByCategoryIdAndSort(int categoryId,String orderByName ,String sortType);

    /**
     * 模糊查询
     * @param content 查询的字段
     * @return  书籍结果
     */
    List<Product> findByLikeSearch(String content);

    /**
     * 根据id 查询 书籍
     * @param id id
     * @return  书籍
     */
    Product findByProductId(int id);

    /**
     * 根据用户 id  查询购物车
     * @param userId  用户id
     * @return  购物车信息
     */
    List<Cart> findByUserId(int userId);

    /**
     * 跟新用户购物车用相同产品的属性
     * @param cart 购物车信息
     * @return  1 成功
     */
    int updateByCartId(Cart cart);

    /**
     * 新增 购物车
     * @param cart 购物车信息
     * @return  1成功
     */
    int insertCart(Cart cart);

    /**
     * 根据用户id 和产品 id 查询 对应的购物车
     * @param userId  用户id
     * @param product_id  产品id
     * @return  购物车
     */
    Cart findByUserIdAndProductId(int userId,int product_id);

    /**
     * 根据用户id 和商品id 删除购物车
     * @param userId  用户id
     * @param product_id  商品id
     * @return 1成功
     */
    int deleteByUserIdAndProduct(int userId, int product_id);

    /**
     * 删除用户所有的购物车
     * @param userId  用户id
     * @return  删除的条数
     */
    int deleteByUserId(int userId);
}

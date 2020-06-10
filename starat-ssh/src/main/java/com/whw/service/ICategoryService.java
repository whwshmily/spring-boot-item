package com.whw.service;

import com.whw.domain.Category;
import com.whw.util.PageCategory;

import java.util.List;

public interface ICategoryService {
    /**
     * 获取所有的商品类别
     *
     * @return 所有的商品类别
     */
    List<Category> findAll();

    /**
     * 保存商品类别
     *
     * @param category 商品类别
     * @return 成功返回id  失败-1；
     */
    int save(Category category);

    /**
     * 根据商品类别id 获取类别
     *
     * @param id id
     * @return 商品类别
     */
    Category findById(int id);

    /**
     * 查询分类的个数
     *
     * @return 个数
     */
     int count();

    /**
     * 分页查询
     *
     * @param pageNumber 第几页
     * @return 分类商品
     */
     PageCategory pageSelect(int pageNumber);
    /**
     * 更新或者删除分类   删除就把属性del 写为1
     * @param category 参数
     */
     void update(Category category);
}

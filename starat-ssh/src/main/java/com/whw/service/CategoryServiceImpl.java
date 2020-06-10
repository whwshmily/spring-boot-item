package com.whw.service;

import com.whw.dao.CategoryDao;
import com.whw.domain.Category;
import com.whw.util.PageCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryDao dao;

    /**
     * 获取所有的商品类别
     *
     * @return 所有的商品类别
     */
    public List<Category> findAll() {
        try {
            return dao.findAll();
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 保存商品类别
     *
     * @param category 商品类别
     * @return 成功返回id  失败-1；
     */
    public int save(Category category) {
        try {
            return dao.save(category);
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 根据商品类别id 获取类别
     *
     * @param id id
     * @return 商品类别
     */
    public Category findById(int id) {
        try {
            return dao.findById(id);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 查询分类的个数
     *
     * @return 个数
     */
    public int count() {
        return dao.count();
    }

    /**
     * 分页查询
     *
     * @param pageNumber 第几页
     * @return 分类商品
     */
    public PageCategory pageSelect(int pageNumber) {
        PageCategory<Category> pageCategory = PageCategory.startPage(pageNumber,count());
        int start = PageCategory.pageStart(pageCategory.getPageNumber());
        List<Category> list = dao.pageSelect(start, PageCategory.getPageSize());
        pageCategory.setList(list);
        return pageCategory;
    }

    /**
     * 更新或者删除分类   删除就把属性del 写为1
     *
     * @param category 参数
     */
    public void update(Category category) {
        dao.update(category);
    }
}

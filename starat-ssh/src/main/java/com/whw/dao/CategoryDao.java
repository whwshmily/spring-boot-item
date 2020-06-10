package com.whw.dao;

import com.whw.domain.Category;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    private SessionUtil util;
    private Session session;

    /**
     * 获取所有的商品类别
     *
     * @return 所有的商品类别
     */
    public List<Category> findAll() {
        test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root);
        query.where(builder.equal(root.get("del"), 0));
        return session.createQuery(query).getResultList();
    }

    /**
     * 保存商品类别
     *
     * @param category 商品类别
     * @return 成功返回id  失败-1；
     */
    public int save(Category category) {
        test();
        return (Integer) session.save(category);
    }

    /**
     * 根据商品类别id 获取类别
     *
     * @param id id
     * @return 商品类别
     */
    public Category findById(int id) {
        test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("id"), id),
                builder.equal(root.get("del"), 0)
        ));
        return session.createQuery(query).getSingleResult();
    }

    /**
     * 查询分类的个数
     *
     * @return 个数
     */
    public int count() {
        return findAll() == null ? 0 : findAll().size();
    }

    /**
     * 分页查询
     *
     * @param pageNumber 第几页
     * @param pageSize   每一页的个数
     * @return 分类商品
     */
    public List<Category> pageSelect(int pageNumber, int pageSize) {
        test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        query.select(root);
        query.where(builder.equal(root.get("del"), 0));
        return session.createQuery(query).setFirstResult(pageNumber).setMaxResults(pageSize)
                .getResultList();
    }

    /**
     * 更新或者删除分类   删除就把属性del 写为1
     *
     * @param category 参数
     */
    public void update(Category category) {
        test();
        session.beginTransaction();
        session.merge(category);
        session.getTransaction().commit();
    }

    private void test() {
        if (session == null)
            session = util.getSession();
    }
}

package com.whw.dao;

import com.whw.domain.Product;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private SessionUtil util;
    private Session session;
    /**
     * 根据商品id 查询商品
     *
     * @param id 商品id
     * @return 商品
     */
    public Product findById(int id) {
        test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> from = query.from(Product.class);
        query.select(from);
        query.where(builder.and(
                builder.equal(from.get("id"), id),
                builder.equal(from.get("del"), 0)
        ));
        return session.createQuery(query).getSingleResult();
    }

    /**
     * 增加商品
     *
     * @param product 商品
     * @return 商品id
     */
    public int save(Product product) {
        test();
        return (Integer) session.save(product);
    }

    public List<Product> findByCategoryId(int id,int first,int max){
        test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("del"),0),
                builder.equal(root.get("category"),id)
        ));
        if (first == -1){
            return session.createQuery(query).getResultList();
        }
        return session.createQuery(query).setFirstResult(first).setMaxResults(max).
                getResultList();
    }
    public int count(int id) {

        return findByCategoryId(id,-1,0) == null ? 0 : findByCategoryId(id,-1,0).size();
    }
    public void update(Product o) {
        test();
        session.beginTransaction();
        session.merge(o);
        session.getTransaction().commit();
    }
    private void test() {
        if (session == null)
            session = util.getSession();
    }
}

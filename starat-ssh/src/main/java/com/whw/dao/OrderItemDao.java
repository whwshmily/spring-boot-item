package com.whw.dao;

import com.whw.domain.OrderItem;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderItemDao {
    @Autowired
    private SessionUtil util;

    /**
     * 保存订单商品
     * @param item 订单商品
     * @return 成功返回id 失败 -1
     */
    public int save(OrderItem item) {
        return (Integer) util.getSession().save(item);
    }

    /**
     * 根据订单id查询订单商品
     * @param oid 订单id
     * @return 订单商品集合 失败 null
     */
    public List<OrderItem> findByOrderTableId(int oid) {
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderItem> query = builder.createQuery(OrderItem.class);
        Root<OrderItem> root = query.from(OrderItem.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("oid"), oid),
                builder.equal(root.get("del"), 0)
        ));
        return session.createQuery(query).getResultList();
    }


}

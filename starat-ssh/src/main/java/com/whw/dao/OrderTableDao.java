package com.whw.dao;

import com.whw.domain.OrderTable;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderTableDao {
    @Autowired
    private SessionUtil util;

    /**
     * 新增订单
     * @param table  新增对象
     * @return 成功返回 id 失败 -1
     */
    public int save(OrderTable table){
        return (Integer) util.getSession().save(table);
    }

    /**
     * 根据订单号查询订单
     * @param orderCode  订单号
     * @return 成功返回订单  失败null
     */
    public OrderTable findByOrderCode(String orderCode){
        Session session =util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderTable> query = builder.createQuery(OrderTable.class);
        Root<OrderTable> root = query.from(OrderTable.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("order_code"),orderCode),
                builder.equal(root.get("del"),0)
        ));
        return session.createQuery(query).getSingleResult();
    }

    /**
     * 根据用户id 查新订单
     * @param userId  用户id
     * @return 成功返回订单 失败 null
     */
    public List<OrderTable> findByUserId(int userId){
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderTable> query = builder.createQuery(OrderTable.class);
        Root<OrderTable> root = query.from(OrderTable.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("uid"),userId),
                builder.equal(root.get("del"),0)
        ));
        return session.createQuery(query).getResultList();
    }
}

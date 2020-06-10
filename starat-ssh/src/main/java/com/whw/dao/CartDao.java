package com.whw.dao;

import com.whw.domain.Cart;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CartDao {
    @Autowired
    private SessionUtil util;

    /**
     * 根据用户id 查询购物车
     *
     * @param userId 用户id
     * @return 成功购物车 失败null
     */
    public List<Cart> findByUserId(int userId) {
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cart> query = builder.createQuery(Cart.class);
        Root<Cart> root = query.from(Cart.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("uid"), userId),
                builder.equal(root.get("del"), 0)
        ));
        return session.createQuery(query).getResultList();
    }

    /**
     * 保存购物车
     * @param cart 购物车
     * @return 成功 返回id  失败-1
     */
    public int save(Cart cart) {
        return (Integer) util.getSession().save(cart);
    }
}

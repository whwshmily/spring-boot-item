package com.whw.dao;

import com.whw.domain.User;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;

@Repository
public class UserDao {

   @Autowired
   private SessionUtil util;
    /**
     * 根据用户名字查询用户
     *
     * @param name 用户名字
     * @return 返回user对象  查不到 null
     */
    public User findByUserName(String name) {
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        query.where(builder.and(builder.equal(root.get("name"), name),
                builder.equal(root.get("del"),0)
                ));
        return session.createQuery(query).getSingleResult();
    }

    /**
     * 新增用户
     *
     * @return 成功 返回 id 失败 -1；
     */
    public int save(User user) {
        Session session = util.getSession();
        return (Integer) session.save(user);
    }

    /**
     * 根据id 查用户
     * @param id id
     * @return 成功 user  失败 null
     */
    public User findById(int id){
        return util.getSession().load(User.class,id);
    }
}

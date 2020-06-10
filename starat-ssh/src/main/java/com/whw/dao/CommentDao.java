package com.whw.dao;

import com.whw.domain.Comment;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CommentDao {
    @Autowired
    private SessionUtil util;
    /**
     *根据产品id产看品论
     * @param productd  产品id
     * @return  成功返回 集合  失败null
     */
    public List<Comment> findByProductId(int productId){
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("pid"),productId),
                builder.equal(root.get("del"),0)
        ));
        return session.createQuery(query).getResultList();
    }

    /**
     * 更具用户id和产品id 产看品论
     * @param userId  用户id
     * @param productId  产品id
     * @return  成功 comment  失败 null；
     */
    public Comment findByUserIdAndProductId(int userId,int productId){
        Session session = util.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("pid"),productId),
                builder.equal(root.get("uid"),userId),
                builder.equal(root.get("del"),0)
        ));
        return session.createQuery(query).getSingleResult();
    }

    /**
     * 新增评论
     * @param comment 评论
     * @return 成功返回id 失败-1
     */
    public int save(Comment comment){
        return (Integer) util.getSession().save(comment);
    }
}

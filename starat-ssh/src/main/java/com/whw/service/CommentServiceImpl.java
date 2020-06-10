package com.whw.service;

import com.whw.dao.CommentDao;
import com.whw.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentDao dao;

    /**
     * 根据产品id产看品论
     *
     * @param productId@return 成功返回 集合  失败null
     */
    public List<Comment> findByProductId(int productId) {
        try {
            return dao.findByProductId(productId);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 更具用户id和产品id 产看品论
     *
     * @param userId    用户id
     * @param productId 产品id
     * @return 成功 comment  失败 null；
     */
    public Comment findByUserIdAndProductId(int userId, int productId) {
        try {
            return dao.findByUserIdAndProductId(userId, productId);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 新增评论
     *
     * @param comment 评论
     * @return 成功返回id 失败-1
     */
    public int save(Comment comment) {
        try {
            return dao.save(comment);
        } catch (Exception e) {

        }
        return -1;
    }
}

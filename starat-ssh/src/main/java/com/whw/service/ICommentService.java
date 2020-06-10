package com.whw.service;

import com.whw.domain.Comment;

import java.util.List;

public interface ICommentService {
    /**
     * 根据产品id产看品论
     *
     * @param productd 产品id
     * @return 成功返回 集合  失败null
     */
    List<Comment> findByProductId(int productId);

    /**
     * 更具用户id和产品id 产看品论
     *
     * @param userId    用户id
     * @param productId 产品id
     * @return 成功 comment  失败 null；
     */
    Comment findByUserIdAndProductId(int userId, int productId);

    /**
     * 新增评论
     *
     * @param comment 评论
     * @return 成功返回id 失败-1
     */
    int save(Comment comment);
}

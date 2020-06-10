package com.whw.service;

import com.whw.domain.Cart;

import java.util.List;

public interface ICartService {
    /**
     * 根据用户id 查询购物车
     *
     * @param userId 用户id
     * @return 成功购物车 失败null
     */
    List<Cart> findByUserId(int userId);

    /**
     * 保存购物车
     *
     * @param cart 购物车
     * @return 成功 返回id  失败-1
     */
    public int save(Cart cart);
}

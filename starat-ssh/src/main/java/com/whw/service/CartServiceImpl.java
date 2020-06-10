package com.whw.service;

import com.whw.dao.CartDao;
import com.whw.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartDao dao;

    /**
     * 根据用户id 查询购物车
     *
     * @param userId 用户id
     * @return 成功购物车 失败null
     */
    public List<Cart> findByUserId(int userId) {
        try {
            return dao.findByUserId(userId);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 保存购物车
     *
     * @param cart 购物车
     * @return 成功 返回id  失败-1
     */
    public int save(Cart cart) {
        try {
            return dao.save(cart);
        } catch (Exception e) {

        }
        return -1;
    }
}

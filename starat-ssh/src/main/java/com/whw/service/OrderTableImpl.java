package com.whw.service;

import com.whw.dao.OrderTableDao;
import com.whw.domain.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableImpl implements IOrderTableService {
    @Autowired
    private OrderTableDao dao;

    /**
     * 新增订单
     *
     * @param table 新增对象
     * @return 成功返回 id 失败 -1
     */
    public int save(OrderTable table) {
        try {
            return dao.save(table);
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 根据订单号查询订单
     *
     * @param orderCode 订单号
     * @return 成功返回订单  失败null
     */
    public OrderTable findByOrderCode(String orderCode) {
        try {
            return dao.findByOrderCode(orderCode);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 根据用户id 查新订单
     *
     * @param userId 用户id
     * @return 成功返回订单 失败 null
     */
    public List<OrderTable> findByUserId(int userId) {
        try {
            return dao.findByUserId(userId);
        } catch (Exception e) {

        }
        return null;
    }
}

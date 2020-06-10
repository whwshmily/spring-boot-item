package com.whw.service;

import com.whw.domain.OrderTable;

import java.util.List;

public interface IOrderTableService {
    /**
     * 新增订单
     *
     * @param table 新增对象
     * @return 成功返回 id 失败 -1
     */
    int save(OrderTable table);

    /**
     * 根据订单号查询订单
     *
     * @param orderCode 订单号
     * @return 成功返回订单  失败null
     */
    OrderTable findByOrderCode(String orderCode);

    /**
     * 根据用户id 查新订单
     *
     * @param userId 用户id
     * @return 成功返回订单 失败 null
     */
    List<OrderTable> findByUserId(int userId);
}

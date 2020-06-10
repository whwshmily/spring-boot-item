package com.whw.service;

import com.whw.domain.OrderItem;

import java.util.List;

public interface IOrderItemService {
    /**
     * 保存订单商品
     *
     * @param item 订单商品
     * @return 成功返回id 失败 -1
     */
    int save(OrderItem item);

    /**
     * 根据订单id查询订单商品
     *
     * @param oid 订单id
     * @return 订单商品集合 失败 null
     */
    List<OrderItem> findByOrderTableId(int oid);
}

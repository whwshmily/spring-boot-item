package com.whw.service;

import com.whw.dao.OrderItemDao;
import com.whw.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderItemDao dao;

    /**
     * 保存订单商品
     *
     * @param item 订单商品
     * @return 成功返回id 失败 -1
     */
    public int save(OrderItem item) {
        try {
            return dao.save(item);
        } catch (Exception e) {

        }
        return -1;
    }

    /**
     * 根据订单id查询订单商品
     *
     * @param oid 订单id
     * @return 订单商品集合 失败 null
     */
    public List<OrderItem> findByOrderTableId(int oid) {
        try {
            return dao.findByOrderTableId(oid);
        } catch (Exception e) {

        }
        return null;
    }
}

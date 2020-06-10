package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_item")
public class OrderItem implements Serializable {
    /**订单商品表，order_item
     * - id，主键
     *- oid，订单id
     *- pid，商品id
     *- count，商品数量
     *- total_price，商品总价格
     *- del，是否删除
     *- create_time，创建时间
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int oid;
    private int pid;
    private int count;
    private double total_price;
    private int del;
    private Date create_time;
}

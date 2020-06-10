package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class OrderTable implements Serializable {
    /**订单表，order_table
     * - id，主键id
     *- order_code，订单号
     *- uid，用户id
     *- address，收货地址
     *- mobile，手机
     *- receivers，收货人
     *- postcode，邮编
     *- message，留言
     *- create_time，创建时间
     *- pay_time，付款时间
     *- delivery_time，发货时间
     *- order_status，订单状态
     *- del，是否删除
     *- order_price，订单价格
     * - confirm_time，确认时间
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String order_code;
    private int uid;
    private String address;
    private String mobile;
    private String receivers;
    private String postcode;
    private String message;
    private Date create_time;
    private Date pay_time;
    private Date delivery_time;
    private int order_status;
    private int del;
    private double order_price;
    private Date confirm_time;
    @OneToMany
    @JoinColumn(name = "oid")
    private Set<OrderItem> items;
}

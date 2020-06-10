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
@Table(name = "cart")
public class Cart implements Serializable {
    /**
     * 购物车表，cart
     * - id，购物车id
     * - uid，用户id
     * - pid，产品id
     * - number，商品数量
     * - del，是否删除
     * - create_time，创建时间
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int uid;
    private int pid;
    private int number;
    private int del;
    private Date create_time;
}

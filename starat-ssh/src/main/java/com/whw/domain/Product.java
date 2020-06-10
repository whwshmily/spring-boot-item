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
@Table(name = "product")
public class Product implements Serializable {
    /** 商品表，product
     * - id，商品id
     *- cid，商品分类id
     *- name，商品名称
     *- sub_title，商品字标题
     *- o_price，原价
     *- n_price，现价
      *- stock，库存
     * image_id，商品图片id
     *- comment_count，评论总数
     *- added，商品是否上架  0上架  1下架
     *- sale_count，销量
     *- delete，是否删除 1删除 0 未删除
     * create_time，创建时间
      */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;
    private String name;
    private String sub_title;
    private double o_price;
    private double n_price;
    private int stock;
    @OneToMany
    @JoinColumn(name = "pid")
    private Set<Imgage> imgages;
    private int comment_count;
    private int added;
    private int sale_count;
    private int del;
    private Date create_time;
}

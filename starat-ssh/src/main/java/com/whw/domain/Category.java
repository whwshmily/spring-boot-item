package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category implements Serializable {
    /**  商品分类表
     *  - id，主键id
     *    - name，类目名称
     *    - recommend，推荐值
     *    - delete，是否删除
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int recommend;
    //是否删除 0未删除  1 删除
    private int del;
    @OneToMany
    @JoinColumn(name="cid")
    private List<Product> products;
}

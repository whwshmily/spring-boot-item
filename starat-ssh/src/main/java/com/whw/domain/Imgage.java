package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imgage")
public class Imgage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //图片地址  路径
    private String url;
    //图片描述
    private String img_desc;
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;
    //1封面图片  2 顶部图片  3 详情图片
    private int type;
    private int del;
}

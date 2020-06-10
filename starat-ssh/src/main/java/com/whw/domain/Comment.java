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
@Table(name = "comment")
public class Comment implements Serializable {
    /**商品评论表，comment
     *- id，主键
     *- pid，商品id
     *- uid，用户id
     *- content，评论内容
     *- create_time，创建时间
     *- del，是否删除
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pid;
    private int uid;
    private String content;
    private Date create_time;
    private int del;
}

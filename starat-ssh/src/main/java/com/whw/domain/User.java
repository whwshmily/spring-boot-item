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
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    /**
     * 用户表，user
     *    - id，用户id
     *    - name，用户名
     *    - email，邮箱
     *    - password，密码
     *    - group，用户组
     *    - delete，是否删除
     *    - create_time，创建时间
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private int user_group;
    //是否删除 0未删除  1 删除
    private int del;
    private Date create_time;
}

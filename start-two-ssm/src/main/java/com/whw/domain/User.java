package com.whw.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private int user_id;
    private String login_name;
    private String nick_name;
    private String real_name;
    private int grade_id;
    private String password;
    private String email;
    private String province;
    private String recommend;
    private String Sex;
    private Date Birth;
    private String location;
    private String school;
    private String company;
    private String card_INT;
    private String mobile;
    private String Phone;
    private String msn;
    private String qq;
    private String website;
    private String send_address;
    private String zipCode;
    private String hobby;
    private String verify_flag;
    private String verify_code;
    private Date last_login_time;
    private String last_login_ip;
    private String area;
    private String head_pic;

    public User(String login_name, String password, String email, String recommend) {
        this.login_name = login_name;
        this.password = password;
        this.email = email;
        this.recommend = recommend;
    }

}

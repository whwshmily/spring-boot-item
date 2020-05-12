package com.whw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class DataBean {
    //城市/省份名字
    private String name;
    //境外输入
    private String tip;
    //现在确诊人数
    private double nowConfirm;
    //总共确诊人数
    private double confirm;
    //疑似人数
    private double suspect;
    //死亡人数
    private double dead;
    //治愈人数
    private double heal;
}

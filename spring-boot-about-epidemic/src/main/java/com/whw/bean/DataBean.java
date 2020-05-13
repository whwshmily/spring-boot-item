package com.whw.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
@TableName("illness")
public class DataBean {
    //城市/省份名字
    private String name;
    //境外输入
    private String tip;
    //现在确诊人数
    private int nowConfirm;
    //总共确诊人数
    private int confirm;
    //疑似人数
    private int suspect;
    //死亡人数
    private int dead;
    //治愈人数
    private int heal;
}

package com.whw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmStatusBean {
    //港澳台确诊人数
    private double gat;
    //境外输入人数
    private double overseas;
    //31本省确诊人数
    private double province;
}

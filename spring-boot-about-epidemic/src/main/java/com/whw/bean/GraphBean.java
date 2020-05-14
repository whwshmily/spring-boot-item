package com.whw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphBean {
    //日期  第几天
    private String date;
    //全国当天确诊人数
    private double nowConfirm;
    //全国新增疑似人数
    private double insertSuspect;
    //全国新增确诊人数
    private double insertConfirm;
    //全国累计确证人数
    private double totalConfirm;
    //全国累计死亡人数
    private double totalDead;
    //全国累计治愈人数
    private double totalHeal;
    //全国死亡率
    private double deadRate;
    //全国治愈率
    private double healRate;
    //累计境外输入人数
    private double  importCase;
    //境外输入率
    private double importCaseRate;
}

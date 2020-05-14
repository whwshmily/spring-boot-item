package com.whw.until;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.whw.bean.DataBean;
import com.whw.service.dataServcie.BaseDataService;
import com.whw.service.dataServcie.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataHandle {

    @Autowired
    private BaseDataService service;
    private static Gson gson = new Gson();

    @PostConstruct
    public void save() {
        List<DataBean> dataBeans = getHandle();
        System.out.println(dataBeans);
        service.remove(null);
        service.saveBatch(dataBeans);
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 8)
    public void update() {
        System.out.println("更新了");
        save();
    }

    public static List<DataBean> getHandle() {
        String utlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        Map totalMap = gson.fromJson(HttpUrlConnectionUntil.sendUrl(utlStr), Map.class);
        String data = (String) totalMap.get("data");
        return parseJSON(data);
    }

    public static List<DataBean> parseJSON(String json) {
        List<DataBean> result = new ArrayList<>();
        Map dataMap = gson.fromJson(json, Map.class);
        //   System.out.println(dataMap);
        ArrayList areaList = (ArrayList) dataMap.get("areaTree");
        Map chinaMess = (LinkedTreeMap) areaList.get(0);
        ArrayList childrenList = (ArrayList) chinaMess.get("children");
        //    System.out.println(childrenList);
        for (int i = 0; i < childrenList.size(); i++) {
            Map childMap = (Map) childrenList.get(i);
            String name = (String) childMap.get("name");
            Map todayMap = (Map) childMap.get("today");
            Map tMap = (Map) childMap.get("total");
            String tip = (String) todayMap.get("tip");
            if (tip.length() == 0 || tip == null || tip == "") {
                tip = "-1";
            } else {

                if (tip.contains("河南") || tip.contains("四川")) {
                    tip = tip.substring(tip.indexOf("报告") + 2, tip.indexOf("例"));
                } else {
                    if (tip.contains("宁夏")) {
                        tip = "3";
                    } else {
                        tip = tip.substring(tip.indexOf("病例") + 2, tip.indexOf("。") - 1);
                    }
                }
            }
            double nowConfirm = (double) tMap.get("nowConfirm");
            double confirm = (double) tMap.get("confirm");
            double suspect = (double) tMap.get("suspect");
            double dead = (double) tMap.get("dead");
            double heal = (double) tMap.get("heal");
            result.add(new DataBean(name, Integer.parseInt(tip), (int) nowConfirm, (int) confirm, (int) suspect, (int) dead, (int) heal));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

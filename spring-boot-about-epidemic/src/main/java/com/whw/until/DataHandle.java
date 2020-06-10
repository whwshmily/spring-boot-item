package com.whw.until;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.whw.bean.DataBean;
import com.whw.bean.MapBean;
import com.whw.service.dataServcie.BaseDataService;
import com.whw.service.dataServcie.DataServiceImpl;
import org.apache.catalina.User;
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
public class DataHandle{

    @Autowired
    private BaseDataService service;
    private static Gson gson = new Gson();

//    @PostConstruct
//    public void save() {
//        List<DataBean> dataBeans = getHandle(null);
//        System.out.println(dataBeans);
//        service.remove(null);
//        service.saveBatch(dataBeans);
//    }
//
//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 8)
//    public void update() {
//        System.out.println("更新了");
//        save();
//    }

    public static List<DataBean> getHandle(List<MapBean> list) {
        String utlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        Map totalMap = gson.fromJson(HttpUrlConnectionUntil.sendUrl(utlStr), Map.class);
        String data = (String) totalMap.get("data");
        return parseJSON(data, list);
    }

    public static List<DataBean> parseJSON(String json, List<MapBean> list) {
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
            Map tMap = (Map) childMap.get("total");
            List childList = (List) childMap.get("children");
            double tip = -1;
            for (int j = 0; j < childList.size(); j++) {
                Map fromAbord = (Map) childList.get(j);
                if ("境外输入".equals(fromAbord.get("name"))) {
                    Map confirm = (Map) fromAbord.get("total");
                    tip = (double) confirm.get("confirm");
                }
            }
            double nowConfirm = (double) tMap.get("nowConfirm");
            double confirm = (double) tMap.get("confirm");
            double suspect = (double) tMap.get("suspect");
            double dead = (double) tMap.get("dead");
            double heal = (double) tMap.get("heal");
            result.add(new DataBean(name, (int) tip, (int) nowConfirm, (int) confirm, (int) suspect, (int) dead, (int) heal));
            if (list != null) {
                list.add(new MapBean(name, (int) nowConfirm));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<MapBean> list = new ArrayList<>();
        getHandle(list);
        System.out.println(list.size());
    }
}

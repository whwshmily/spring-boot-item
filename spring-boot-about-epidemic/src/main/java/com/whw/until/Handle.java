package com.whw.until;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.whw.bean.DataBean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Handle {
    private static Gson gson = new Gson();

    public static List<DataBean> getHandle() {
        String utlStr = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
        Map totalMap = gson.fromJson(HttpUrlConnectionUntil.sendUrl(utlStr), Map.class);
        String data = (String) totalMap.get("data");
        return parseJSON(data);
}

    private static List<DataBean> parseJSON(String json) {
        List<DataBean> result = new ArrayList<>();
        Map dataMap = gson.fromJson(json, Map.class);
        ArrayList areaList = (ArrayList) dataMap.get("areaTree");
        Map chinaMess = (LinkedTreeMap) areaList.get(0);
        ArrayList childrenList = (ArrayList) chinaMess.get("children");
        for (int i = 0; i < childrenList.size(); i++) {
            Map childMap = (Map) childrenList.get(i);
            String name = (String) childMap.get("name");
            Map todayMap = (Map) childMap.get("today");
            Map tMap = (Map) childMap.get("total");
            String tip = (String) todayMap.get("tip");
            double nowConfirm = (double) tMap.get("nowConfirm");
            double confirm = (double) tMap.get("confirm");
            double suspect = (double) tMap.get("suspect");
            double dead = (double) tMap.get("dead");
            double heal = (double) tMap.get("heal");
            result.add(new DataBean(name, tip, nowConfirm, confirm, suspect, dead, heal));
        }
        return result;
    }
}

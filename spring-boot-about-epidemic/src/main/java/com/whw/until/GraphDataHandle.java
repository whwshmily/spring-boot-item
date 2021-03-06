package com.whw.until;

import com.google.gson.Gson;
import com.whw.bean.ConfirmStatusBean;

import com.whw.bean.GraphBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDataHandle {
    private static Map handleData() {
        String dataJson = HttpClientUtil.doGet("https://view.inews.qq.com/g2/getOnsInfo?name=disease_other");
        Gson gson = new Gson();
        Map dataMap = gson.fromJson(dataJson, Map.class);
        String dataStr = (String) dataMap.get("data");
        Map dayMap = gson.fromJson(dataStr, Map.class);
        //System.out.println(dayMap);
        return dayMap;
    }

    public static List<ConfirmStatusBean> handleNowConfirmStatus() {
        List<ConfirmStatusBean> list = new ArrayList<>();
        Map dayMap = handleData();
        Map map = (Map) dayMap.get("nowConfirmStatis");
        Set set = map.keySet();
        for (Object o : set) {
            double value = (double) map.get(o);
            ConfirmStatusBean bean = new ConfirmStatusBean();
            String key = (String) o;

            switch (key) {
                case "gat":
                    key = "港澳台病例:"+value;
                    break;
                case "import":
                    key = "境外输入病例:"+value;
                    break;
                case "province":
                    key = "31省本土病例:"+value;
                    break;
            }
            bean.setName(key);
            bean.setValue(value);
            list.add(bean);
        }
        return list;
    }

    public static List<GraphBean> handleOtherAboutGraph() {
        List<GraphBean> beanList = new ArrayList<>();
        Map dayMap = handleData();
        List dayList = (List) dayMap.get("chinaDayList");
        for (int i = 0; i < dayList.size(); i++) {
            Map graphMap = (Map) dayList.get(i);
            String date = (String) graphMap.get("date");
            double nowConfirm = (double) graphMap.get("nowConfirm");
            double totalConfirm = (double) graphMap.get("confirm");
            double totalDead = (double) graphMap.get("dead");
            double totalHeal = (double) graphMap.get("heal");
            double importCase = (double) graphMap.get("importedCase");
            String deadRate = (String) graphMap.get("deadRate");
            String healRate = (String) graphMap.get("healRate");
            GraphBean bean = new GraphBean();
            bean.setDate(date);
            bean.setNowConfirm(nowConfirm);
            bean.setTotalConfirm(totalConfirm);
            bean.setTotalDead(totalDead);
            bean.setTotalHeal(totalHeal);
            bean.setImportCase(importCase);
            bean.setDeadRate(Double.parseDouble(deadRate));
            bean.setHealRate(Double.parseDouble(healRate));
            beanList.add(bean);
        }
        return beanList;
    }

    public static List<GraphBean> handleInsertSuspectAndConfirm() {
        List<GraphBean> beanList = new ArrayList<>();
        Map dayMap = handleData();
        List dayList = (List) dayMap.get("chinaDayAddList");
        for (int i = 0; i < dayList.size(); i++) {
            Map graphMap = (Map) dayList.get(i);
            String date = (String) graphMap.get("date");
            double confirm = (double) graphMap.get("confirm");
            double suspect = (double) graphMap.get("suspect");
            double importCase = (double) graphMap.get("importedCase");
            GraphBean bean = new GraphBean();
            bean.setInsertConfirm(confirm);
            bean.setInsertSuspect(suspect);
            bean.setImportCaseRate(importCase);
            bean.setDate(date);
            beanList.add(bean);
        }
        return beanList;
    }

    public static void main(String[] args) {
        System.out.println(handleNowConfirmStatus());
        //System.out.println(handleOtherAboutGraph());
        // System.out.println(handleInsertSuspectAndConfirm());
    }
}

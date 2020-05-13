package com.whw.until;

import com.google.gson.Gson;
import com.whw.bean.DataBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupHandle {

    public static void main(String[] args) {
        List<DataBean> result = handleHtml();
        System.out.println(result);
    }

    public static List<DataBean> handleHtml() {
        String urlStr = "https://ncov.dxy.cn/ncovh5/view/pneumonia?scene=2&from=singlemessage&isappinstalled=0";
        List<DataBean> result = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(urlStr).get();
            Elements elements = doc.getElementsByTag("script");
            Element element = doc.getElementById("getAreaStat");
            // System.out.println(element);
            String data = element.data();
            data = data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
            Gson gson = new Gson();
            List list = gson.fromJson(data, List.class);
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String name = (String) map.get("provinceName");
                double confirm = (double) map.get("confirmedCount");
                double nowConfirm = (double) map.get("currentConfirmedCount");
                double suspect = (double) map.get("suspectedCount");
                double dead = (double) map.get("deadCount");
                double heal = (double) map.get("curedCount");
                DataBean b = new DataBean(name, "", (int) nowConfirm, (int) confirm, (int) suspect, (int) dead, (int) heal);
                result.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

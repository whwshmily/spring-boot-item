package com.whw.until;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectionUntil {
    public static String sendUrl(String urlStr) {
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            //设置请求的类型
            conn.setRequestMethod("GET");
            //设置连接资源的时间
            conn.setConnectTimeout(15000);
            //设置读取时间的资源
            conn.setReadTimeout(5000);
            //设置响应的格式json
            //conn.setRequestProperty("Accept", "application/json");
            //发送请求
            conn.connect();
            //获取响应的状态码
            int code = conn.getResponseCode();
            if (code != 200) {
                return "error";
            }
            //获取请求回来的数据
            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = sendUrl("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5");
        String s1 = sendUrl("https://ncov.dxy.cn/ncovh5/view/pneumonia?scene=2&from=singlemessage&isappinstalled=0");
        System.out.println(s1);
    }
}

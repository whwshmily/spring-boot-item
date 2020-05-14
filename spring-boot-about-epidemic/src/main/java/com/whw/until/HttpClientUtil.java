package com.whw.until;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import javax.swing.text.html.parser.Entity;

public class HttpClientUtil {
    public static String doGet(String urlStr) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            client = HttpClients.createDefault();
            HttpGet get = new HttpGet(urlStr);
            get.setHeader("accept", "application/json");
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(15000)
                    .setSocketTimeout(15000)
                    .setConnectionRequestTimeout(15000).build();
            get.setConfig(config);
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
       String str = doGet("https://view.inews.qq.com/g2/getOnsInfo?name=disease_other");
        System.out.println(str);
    }
}

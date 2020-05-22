package com.whw.until;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

    public static void sendMail() throws Exception {
        //将单的传输协议 smtp  simple mail transport protocol
        //设置配置环境
        Properties p = new Properties();
        //设置协议和服务器地址
        p.setProperty("mail.transport.protocol","smtp");
        p.setProperty("mail.smtp.host","smtp.qq.com");
        p.setProperty("mail.smpt.auth","true");
        //设置端口 配置ssl相关
        String port = "465";
        p.setProperty("mail.smtp.port",port);
        p.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtp.socketFactory.fallback","false");
        p.setProperty("mail.smtp.socketFactory",port);

        //创建会话session对象
        Session session = Session.getInstance(p);
        //创建 一封邮件
        MimeMessage message = new MimeMessage(session);
        //收件人
        String send = "962188045@qq.com";
        //发件人
        String recipients = "whw0505@126.com";
        //设置邮件的发件人和收件人
        message.setSender(new InternetAddress(send,"whw","UTF-8"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipients,"126","UTF-8"));
        //设置标题 正文 发件时间
        message.setSubject("来自原生JAVA的信息");
        message.setContent("你收到了呀，成功了","text.html;charset=utf-8");
        message.setSentDate(new Date());
        //保存设置
        message.saveChanges();
        //创建transport传输对象
        Transport transport = session.getTransport();
        String user = "962188045@qq.com";
        String pass = "nmqzsnfyycwkbdgc";
        transport.connect(user,pass);
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

    public static void main(String[] args) throws Exception {
        sendMail();
    }
}

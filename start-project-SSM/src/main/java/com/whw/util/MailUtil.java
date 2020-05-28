package com.whw.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

    public static void sendMail(String receiveMail, String content, String subject) throws Exception {
        /**
         * 配置协议环境，参数
         */
        Properties prop = new Properties();
        //设置传输协议
        prop.setProperty("mail.transport.protocol", "smtp");
        //设置协议的 host
        prop.setProperty("mail.smtp.host", "smtp.qq.com");
        //设置是否认证
        prop.setProperty("mail.smtp.auth", "true");
        //设置端口
        prop.setProperty("mail.smtp.port", "465");
        /**
         * 设置 ssl相关的配置  端口 等等
         */
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");
        prop.setProperty("mail.smtp.socketFactory.port", "465");
        //创建session对象
        Session session = Session.getInstance(prop);
        //创建mail对象
        MimeMessage message = new MimeMessage(session);
        //设置发件人
        String send = "962188045@qq.com";
        message.setSender(new InternetAddress(send, "阿伟", "UTF-8"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMail,"whw","UTF-8"));
        //设置标题
        message.setSubject(subject);
        //设置内容
        message.setContent(content, "text/html;charset=utf-8");
        //设置发送时间
        message.setSentDate(new Date());
        //保存邮件
        message.saveChanges();
        //获取transport对象
        Transport transport = session.getTransport();
        String password = "knhjfgxizjvkbdgd";//
        //设置发送邮件账户   设置发送邮件密码
        transport.connect(send, password);
        //发送
        transport.sendMessage(message, message.getAllRecipients());
        //关闭
        transport.close();

    }
}


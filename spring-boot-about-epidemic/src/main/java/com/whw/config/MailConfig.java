package com.whw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.*;


@Component
public class MailConfig {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(){
        //获取简单mess对象
        SimpleMailMessage message = new SimpleMailMessage();
        //设置标题
        message.setSubject("来自spring-boot的初次体验");
        //设置内容
        message.setText("hello 再一次发送邮件");
        //设置收件人
        message.setTo("whw0505@126.com");
        //设置发送人
        message.setFrom("962188045@qq.com");
        //发送
        mailSender.send(message);
    }
    @Autowired
    private TemplateEngine engine;

    public void send(){
        List list = new ArrayList();
        list.add("人生重要的，不是能力而是性格；不是成功而是价值；不是你认识多少人，而是在你离开人世时，有多少人认识了你！不是他所购买到的，而是他所创造的；不是他所得到的，而是他所付出的；不是他所学到的，而是他所传授的。");

        list.add("用快乐去奔跑，用心去倾听，用思维去发展，用努力去奋斗，用目标去衡量，用爱去生活。");

        list.add("每个人的一生都有许多梦想，但如果其中一个不断搅扰着你，剩下的就仅仅是行动了。");

        list.add("人生是由咸甜苦辣所组成，学会适应，让你的环境变得明亮；学会调节，让你的心情不再忧伤；学会宽容，让你的生活没有烦恼；学会奉献，让你的人生充满阳光。其实天很蓝，阴云总会散；其实海不宽，彼岸连此岸；其实梦很浅，万物皆自然；其实泪也甜，当你心如愿。人生原本就是修行的道场。");

        list.add("人生充满了起起落落。关键在于，在顶端时好好享受；在低谷时不失勇气。");

        list.add("路，走不通时，学会拐弯，结，解不开时，学会忘记；事，难以做时，学会放下；缘，渐行远时，选择随意。");
        try {
            //创建mess
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //设置标题
            helper.setSubject("来自springboot再次的问候");
            //设置内容
           // helper.setText("hello godbye");
            //设置收件人
            helper.setTo("whw0505@126.com");
            //设置发送人
            helper.setFrom("962188045@qq.com");
            //thymeleaf动态渲染  接收动态参数
            Context context = new Context();
            Map map = new HashMap();
            int index = new Random().nextInt(list.size());
            map.put("title","whw同学");
            map.put("content",list.get(index));
            context.setVariables(map);
            String result =  engine.process("mailTest",context);
            //设置内容
            helper.setText(result,true);
            //设置附件
            String filePath = "E:\\copy\\hibernate\\H\\hibernate01.txt";
            FileSystemResource r = new FileSystemResource(new File(filePath));
            helper.addAttachment("附件",r);
            //发送
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}

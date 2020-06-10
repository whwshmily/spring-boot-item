package com.whw.test;

import com.mysql.cj.xdevapi.SessionFactory;
import com.whw.domain.Cart;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Cart> list = new ArrayList<>();
        for (int i = 0; i <2 ; i++) {

        }
        Test test = new Test();
        Proxy.newProxyInstance(test.getClass().getClassLoader(), new Class[]{test.getClass()}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        BeanFactory f = new ClassPathXmlApplicationContext("");
        ApplicationContext context = new ClassPathXmlApplicationContext("");
    }
}

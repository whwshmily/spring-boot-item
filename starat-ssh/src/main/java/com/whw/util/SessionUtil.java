package com.whw.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
    @Autowired
    private SessionFactory factory;
    public Session getSession(){
        return factory.openSession();
    }
}

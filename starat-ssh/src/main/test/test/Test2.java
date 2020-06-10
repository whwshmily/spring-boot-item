package test;

import com.whw.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("application.xml");
        UserDao dao = (UserDao) factory.getBean("userDao");
        System.out.println(dao);
    }
}

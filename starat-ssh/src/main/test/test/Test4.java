package test;

import com.whw.domain.User;
import com.whw.test.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class Test4 {
    @Autowired
    TestUser user;
    @Test
    public void ti(){
//        System.out.println(user.get(1));
//        System.out.println(user.findAll(new User()));
    }
}

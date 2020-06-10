package test;

import com.whw.dao.*;
import com.whw.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class Test3 {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ImgageDao imgageDao;
    @Autowired
    private OrderTableDao tableDao;
    @Autowired
    private OrderItemDao itemDao;
    @Test
    public void t1(){
        Cart cart = new Cart(-1,1,1,1,0,new Date());
        System.out.println(        cartDao.save(cart));
        System.out.println(cartDao.findByUserId(1));
    }
    @Test
    public void t2(){
        Comment comment = new Comment(-1,1,1,"sss",new Date(),0);
        System.out.println(commentDao.save(comment));
        System.out.println(commentDao.findByProductId(1));
        System.out.println(commentDao.findByUserIdAndProductId(1,1));
    }
    @Test
    public void t3(){
//        Imgage imgage = new Imgage(-1,"uuu","sss",null);
//        System.out.println(imgageDao.save(imgage));
//        System.out.println(imgageDao.findByID(1));
    }
    @Test
    public void t4(){
        OrderTable table = new OrderTable(-1,"123456",1,"ppp","111","sss","5555","sss",new Date()
        ,new Date(),null,0,0,100,null,null
        );
        System.out.println(tableDao.save(table));
        System.out.println(tableDao.findByOrderCode("123456"));
        System.out.println(tableDao.findByUserId(1));
    }
    @Test
    public void t5(){
        OrderItem item = new OrderItem(-1,1,1,1,100,0,new Date());
        System.out.println(itemDao.save(item));
        System.out.println(itemDao.findByOrderTableId(1));
    }
}

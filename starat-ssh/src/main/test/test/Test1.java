package test;

import com.whw.dao.CategoryDao;
import com.whw.dao.ProductDao;
import com.whw.dao.UserDao;
import com.whw.domain.Category;
import com.whw.domain.Product;
import com.whw.domain.User;
import com.whw.util.PageCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class Test1 {
    @Autowired
    private UserDao dao;
    @Autowired
    private CategoryDao dao1;
    @Autowired
    private ProductDao dao2;

    @org.junit.Test
    public void t1(){
        User user = new User(-1,"xiaoqiu","mail","1010",1,0,new Date());
//        System.out.println(dao.save(user));
        System.out.println(dao.findByUserName("admin"));
    }

    @Test
    public void t2(){
//        Category category = dao1.findById(2);
       // System.out.println(dao1.save(category));
//        System.out.println(dao1.findAll());
//        System.out.println(dao1.findById(1).getProducts());
//        Category category = dao1.findById(2);
//       category.setDel(1);
//        dao1.update(category);

        for (int i = 31; i <300 ; i++) {
            Category category = new Category(-1,"手机"+i,i,0,null);
            dao1.save(category);
        }


    }
    @Test
    public void t3(){
        Category category = new Category();
        category.setId(7);
        for (int i = 0; i <500 ; i++) {
            Product product = new Product(-1,category,"华为"+i,"mata20"+i,6666+i,6333+i,0+i,null,i,i,i,0,new Date());
            dao2.save(product);
        }
        //System.out.println(dao2.save(product));
       // System.out.println(dao2.findById(3).getCategory().getId());
       // System.out.println( dao2.findByCategoryId(5).get(0).getCategory().getId());
        System.out.println(dao2.findByCategoryId(5,-1,10).get(0).getCategory().getName());
    }

}

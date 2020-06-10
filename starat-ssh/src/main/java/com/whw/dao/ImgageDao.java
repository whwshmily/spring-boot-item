package com.whw.dao;

import com.whw.domain.Imgage;
import com.whw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ImgageDao {
    @Autowired
    private SessionUtil util;
    private Session session;
    /**
     * 根据id 查询图片信息
     *
     * @param id id
     * @return 成功图片 失败 null
     */
    public List<Imgage> findByProductId(int pid) {
       test();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Imgage> query = builder.createQuery(Imgage.class);
        Root<Imgage> root = query.from(Imgage.class);
        query.select(root);
        query.where(builder.and(
                builder.equal(root.get("product"), pid),
                builder.equal(root.get("del"), 0)
        ));
        return session.createQuery(query).getResultList();
    }

    /**
     * 增加图片
     *
     * @param imgage 图片
     * @return 图片id  失败 -1
     */
    public int save(Imgage imgage) {
        test();
        return (Integer) session.save(imgage);
    }

    public Imgage get(int id){
        test();
    return session.get(Imgage.class,id);
    }
    public void update(Imgage imgage){
        test();
        session.beginTransaction();
        session.update(imgage);
        session.getTransaction().commit();
    }
    private void test() {
        if (session == null)
            session = util.getSession();
    }

}

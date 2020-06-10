package com.whw.service;

import com.whw.dao.ImgageDao;
import com.whw.domain.Imgage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgageServiceImpl implements IImgageService {
    @Autowired
    private ImgageDao dao;

    /**
     * 根据id 查询图片信息
     *
     * @param pid id
     * @return 成功图片 失败 null
     */
    public List<Imgage> findByProductId(int pid) {
        try {
            return dao.findByProductId(pid);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 增加图片
     *
     * @param imgage 图片
     * @return 图片id  失败 -1
     */
    public int save(Imgage imgage) {
        try {
            return dao.save(imgage);
        } catch (Exception e) {

        }
        return -1;
    }

    public Imgage get(int id) {
        return dao.get(id);
    }

    public void update(Imgage imgage) {
        dao.update(imgage);
    }
}

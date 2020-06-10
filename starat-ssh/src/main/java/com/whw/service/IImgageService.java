package com.whw.service;

import com.whw.domain.Imgage;

import java.util.List;

public interface IImgageService {
    /**
     * 根据id 查询图片信息
     *
     * @param pid id
     * @return 成功图片 失败 null
     */
    List<Imgage> findByProductId(int pid);

    /**
     * 增加图片
     *
     * @param imgage 图片
     * @return 图片id  失败 -1
     */
    int save(Imgage imgage);
    Imgage get(int id);
    void update(Imgage imgage);
}

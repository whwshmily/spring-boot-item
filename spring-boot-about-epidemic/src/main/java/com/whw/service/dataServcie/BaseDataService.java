package com.whw.service.dataServcie;

import com.whw.bean.DataBean;

import java.util.List;

public interface BaseDataService {
    /**
     * 获取所有的数据
     * @return
     */
    List<DataBean> findAll();
}

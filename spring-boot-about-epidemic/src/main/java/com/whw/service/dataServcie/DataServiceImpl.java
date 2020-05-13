package com.whw.service.dataServcie;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whw.bean.DataBean;
import com.whw.dao.DataDao;
import com.whw.until.DataHandle;
import com.whw.until.JsoupHandle;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImpl extends ServiceImpl<DataDao,DataBean> implements BaseDataService {
   /* *//**
     * 获取所有的数据
     *
     * @return
     *//*
    @Override
    public List<DataBean> findAll() {
        return DataHandle.getHandle();
    }

    @Override
    public List<DataBean> findById(int id) {
        if (id == 2){
            return JsoupHandle.handleHtml();
        }
        return findAll();
    }*/
}

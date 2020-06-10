package com.whw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whw.bean.DataBean;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends BaseMapper<DataBean> {
}

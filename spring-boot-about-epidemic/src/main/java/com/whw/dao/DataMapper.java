package com.whw.dao;

import com.whw.bean.DataBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {
    @Select("select * from illness order by tip desc limit 0,9")
    List<DataBean> findBytipDesc();
}

package com.whw.service.dataServcie;

import com.whw.bean.DataBean;
import com.whw.until.Handle;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import java.util.List;
@Service
public class DataServiceImpl implements BaseDataService {
    /**
     * 获取所有的数据
     *
     * @return
     */
    @Override
    public List<DataBean> findAll() {
        return Handle.getHandle();
    }
}

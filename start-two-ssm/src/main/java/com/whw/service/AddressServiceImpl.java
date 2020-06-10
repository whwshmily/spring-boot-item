package com.whw.service;

import com.whw.dao.AddressDao;
import com.whw.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService{
    @Autowired
    private AddressDao dao;
    /**
     * 查尊用户的所有收货地址
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<Address> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}

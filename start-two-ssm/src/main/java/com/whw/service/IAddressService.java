package com.whw.service;

import com.whw.domain.Address;

import java.util.List;

public interface IAddressService {
    /**
     * 查尊用户的所有收货地址
     * @param userId  用户id
     * @return
     */
    List<Address> findByUserId(int userId);
}

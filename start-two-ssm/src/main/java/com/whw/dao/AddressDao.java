package com.whw.dao;

import com.whw.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressDao {
    @Select("SELECT ADDRESS_ID , USER_ID , NAME , PROVINCED, ADDRESS, PHONE ,TELL_PHONE , EMAIL , CODE FROM BOOK_ADDRESS WHERE USER_ID = #{userId}" )
    List<Address> findByUserId(int userId);
}

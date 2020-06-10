package com.whw.dao;

import com.whw.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM BOOK_USER WHERE LOGIN_NAME = #{loginName} AND password = #{password}")
    User findByNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);

    @Update("UPDATE BOOK_USER SET LAST_LOGIN_TIME = NOW() WHERE USER_ID = #{ID}")
    void updateLastLoginTime(int id);

    @Select("SELECT LOGIN_NAME FROM BOOK_USER")
    List<String> findAllUserLoginName();

//    @Options(keyColumn = "",keyProperty ="" ,useGeneratedKeys = true)
    @Insert("INSERT INTO BOOK_USER (LOGIN_NAME,PASSWORD,EMAIL ,RECOMMEND) VALUES(#{login_name} ,#{password} ,#{email},#{recommend})")
    int insertUser(User user);
}

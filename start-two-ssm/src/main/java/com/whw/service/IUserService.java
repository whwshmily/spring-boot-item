package com.whw.service;

import com.whw.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 根据id修改最后登录时间
     * @param id userId
     */
    void updateLastLoginTime(int id);

    /**
     * 根据登录名字和密码查询user
     * @param loginName  用户名
     * @param password   密码
     * @return  user对象
     */
    User findByNameAndPassword(String loginName,String password);

    /**
     * 查询所有的用户姓名
     * @return  所有用户姓名
     */
    List<String> findAllUserLoginName();

    /**
     * 新增用户
     * @param user  用户信息
     * @return  成功 1
     */
    int insertUser(User user);
}

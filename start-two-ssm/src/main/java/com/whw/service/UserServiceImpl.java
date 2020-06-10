package com.whw.service;

import com.whw.dao.UserDao;
import com.whw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;
    /**
     * 根据id修改最后登录时间
     *
     * @param id userId
     */
    @Override
    public void updateLastLoginTime(int id) {
        dao.updateLastLoginTime(id);
    }

    /**
     * 根据登录名字和密码查询user
     *
     * @param loginName 用户名
     * @param password  密码
     * @return user对象
     */
    @Override
    public User findByNameAndPassword(String loginName, String password) {
        return dao.findByNameAndPassword(loginName,password);
    }

    /**
     * 查询所有的用户姓名
     *
     * @return 所有用户姓名
     */
    @Override
    public List<String> findAllUserLoginName() {
        return dao.findAllUserLoginName();
    }

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 成功 1
     */
    @Override
    public int insertUser(User user) {
        return dao.insertUser(user);
    }
}
